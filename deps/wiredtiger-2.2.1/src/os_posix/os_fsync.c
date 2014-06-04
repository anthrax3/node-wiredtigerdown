/*-
 * Copyright (c) 2008-2014 WiredTiger, Inc.
 *	All rights reserved.
 *
 * See the file LICENSE for redistribution information.
 */

#include "wt_internal.h"

/*
 * __wt_fsync --
 *	Flush a file handle.
 */
int
__wt_fsync(WT_SESSION_IMPL *session, WT_FH *fh)
{
	WT_DECL_RET;

	WT_RET(__wt_verbose(session, WT_VERB_FILEOPS, "%s: fsync", fh->name));

#ifdef HAVE_FDATASYNC
	WT_SYSCALL_RETRY(fdatasync(fh->fd), ret);
#else
	WT_SYSCALL_RETRY(fsync(fh->fd), ret);
#endif
	if (ret != 0)
		WT_RET_MSG(session, ret, "%s fsync error", fh->name);

	return (0);
}
