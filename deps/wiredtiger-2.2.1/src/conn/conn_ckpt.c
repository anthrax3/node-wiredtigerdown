/*-
 * Copyright (c) 2008-2014 WiredTiger, Inc.
 *	All rights reserved.
 *
 * See the file LICENSE for redistribution information.
 */

#include "wt_internal.h"

static int __ckpt_server_start(WT_CONNECTION_IMPL *);

/*
 * __ckpt_server_config --
 *	Parse and setup the checkpoint server options.
 */
static int
__ckpt_server_config(WT_SESSION_IMPL *session, const char **cfg, int *startp)
{
	WT_CONFIG_ITEM cval;
	WT_CONNECTION_IMPL *conn;
	WT_DECL_ITEM(tmp);
	WT_DECL_RET;

	conn = S2C(session);

	/*
	 * The checkpoint configuration requires a wait time -- if it's not set,
	 * we're not running at all.
	 */
	WT_RET(__wt_config_gets(session, cfg, "checkpoint.wait", &cval));
	if (cval.val == 0) {
		*startp = 0;
		return (0);
	}
	conn->ckpt_usecs = (long)cval.val * 1000000;
	*startp = 1;

	WT_RET(__wt_config_gets(session, cfg, "checkpoint.name", &cval));

	if (!WT_STRING_MATCH(WT_CHECKPOINT, cval.str, cval.len)) {
		WT_RET(__wt_scr_alloc(session, cval.len + 20, &tmp));
		strcpy((char *)tmp->data, "name=");
		strncat((char *)tmp->data, cval.str, cval.len);
		ret = __wt_strndup(session,
		    tmp->data, strlen("name=") + cval.len, &conn->ckpt_config);
		__wt_scr_free(&tmp);
		WT_RET(ret);
	}

	return (0);
}

/*
 * __ckpt_server --
 *	The checkpoint server thread.
 */
static void *
__ckpt_server(void *arg)
{
	WT_CONNECTION_IMPL *conn;
	WT_DECL_RET;
	WT_SESSION *wt_session;
	WT_SESSION_IMPL *session;

	session = arg;
	conn = S2C(session);
	wt_session = (WT_SESSION *)session;

	while (F_ISSET(conn, WT_CONN_SERVER_RUN) &&
	    F_ISSET(conn, WT_CONN_SERVER_CHECKPOINT)) {
		/* Checkpoint the database. */
		WT_ERR(wt_session->checkpoint(wt_session, conn->ckpt_config));

		/* Wait... */
		WT_ERR_TIMEDOUT_OK(
		    __wt_cond_wait(session, conn->ckpt_cond, conn->ckpt_usecs));
	}

	if (0) {
err:		__wt_err(session, ret, "checkpoint server error");
	}
	return (NULL);
}

/*
 * __ckpt_server_start --
 *	Start the checkpoint server thread.
 */
static int
__ckpt_server_start(WT_CONNECTION_IMPL *conn)
{
	WT_SESSION_IMPL *session;

	session = conn->default_session;

	/* Nothing to do if the server is already running. */
	if (conn->ckpt_session != NULL)
		return (0);

	F_SET(conn, WT_CONN_SERVER_CHECKPOINT);
	/* The checkpoint server gets its own session. */
	WT_RET(__wt_open_session(conn, 1, NULL, NULL, &conn->ckpt_session));
	conn->ckpt_session->name = "checkpoint-server";

	WT_RET(
	    __wt_cond_alloc(session, "checkpoint server", 0, &conn->ckpt_cond));

	/*
	 * Start the thread.
	 */
	WT_RET(__wt_thread_create(
	    session, &conn->ckpt_tid, __ckpt_server, conn->ckpt_session));
	conn->ckpt_tid_set = 1;

	return (0);
}

/*
 * __wt_checkpoint_server_create --
 *	Configure and start the checkpoint server.
 */
int
__wt_checkpoint_server_create(WT_CONNECTION_IMPL *conn, const char *cfg[])
{
	int start;

	start = 0;

	/* If there is already a server running, shut it down. */
	if (conn->ckpt_session != NULL)
		WT_RET(__wt_checkpoint_server_destroy(conn));

	WT_RET(__ckpt_server_config(conn->default_session, cfg, &start));
	if (start)
		WT_RET(__ckpt_server_start(conn));

	return (0);
}

/*
 * __wt_checkpoint_server_destroy --
 *	Destroy the checkpoint server thread.
 */
int
__wt_checkpoint_server_destroy(WT_CONNECTION_IMPL *conn)
{
	WT_DECL_RET;
	WT_SESSION *wt_session;
	WT_SESSION_IMPL *session;

	session = conn->default_session;

	F_CLR(conn, WT_CONN_SERVER_CHECKPOINT);
	if (conn->ckpt_tid_set) {
		WT_TRET(__wt_cond_signal(session, conn->ckpt_cond));
		WT_TRET(__wt_thread_join(session, conn->ckpt_tid));
		conn->ckpt_tid_set = 0;
	}
	WT_TRET(__wt_cond_destroy(session, &conn->ckpt_cond));

	__wt_free(session, conn->ckpt_config);

	/* Close the server thread's session. */
	if (conn->ckpt_session != NULL) {
		wt_session = &conn->ckpt_session->iface;
		WT_TRET(wt_session->close(wt_session, NULL));
	}

	/*
	 * Ensure checkpoint settings are cleared - so that reconfigure doesn't
	 * get confused.
	 */
	conn->ckpt_session = NULL;
	conn->ckpt_tid_set = 0;
	conn->ckpt_cond = NULL;
	conn->ckpt_config = NULL;
	conn->ckpt_usecs = 0;

	return (ret);
}
