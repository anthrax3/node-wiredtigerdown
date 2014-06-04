/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.wiredtiger.db;

/**
 * @defgroup wt_java WiredTiger Java API
 *
 * Java wrappers around the WiredTiger C API.
 */

/**
 * @ingroup wt_java
 */

public interface wiredtigerConstants {
  public final static int WIREDTIGER_VERSION_MAJOR = 2;
  public final static int WIREDTIGER_VERSION_MINOR = 2;
  public final static int WIREDTIGER_VERSION_PATCH = 1;
  public final static String WIREDTIGER_VERSION_STRING = "WiredTiger 2.2.1: (May 21, 2014)";
  public final static int WT_DEADLOCK = -31800;
  public final static int WT_DUPLICATE_KEY = -31801;
  public final static int WT_ERROR = -31802;
  public final static int WT_NOTFOUND = -31803;
  public final static int WT_PANIC = -31804;
  public final static int WT_RESTART = -31805;
  public final static int WT_STAT_CONN_ASYNC_ALLOC_RACE = 1000;
  public final static int WT_STAT_CONN_ASYNC_ALLOC_VIEW = 1001;
  public final static int WT_STAT_CONN_ASYNC_CUR_QUEUE = 1002;
  public final static int WT_STAT_CONN_ASYNC_FLUSH = 1003;
  public final static int WT_STAT_CONN_ASYNC_FULL = 1004;
  public final static int WT_STAT_CONN_ASYNC_MAX_QUEUE = 1005;
  public final static int WT_STAT_CONN_ASYNC_NOWORK = 1006;
  public final static int WT_STAT_CONN_ASYNC_OP_ALLOC = 1007;
  public final static int WT_STAT_CONN_ASYNC_OP_COMPACT = 1008;
  public final static int WT_STAT_CONN_ASYNC_OP_INSERT = 1009;
  public final static int WT_STAT_CONN_ASYNC_OP_REMOVE = 1010;
  public final static int WT_STAT_CONN_ASYNC_OP_SEARCH = 1011;
  public final static int WT_STAT_CONN_ASYNC_OP_UPDATE = 1012;
  public final static int WT_STAT_CONN_BLOCK_BYTE_MAP_READ = 1013;
  public final static int WT_STAT_CONN_BLOCK_BYTE_READ = 1014;
  public final static int WT_STAT_CONN_BLOCK_BYTE_WRITE = 1015;
  public final static int WT_STAT_CONN_BLOCK_MAP_READ = 1016;
  public final static int WT_STAT_CONN_BLOCK_PRELOAD = 1017;
  public final static int WT_STAT_CONN_BLOCK_READ = 1018;
  public final static int WT_STAT_CONN_BLOCK_WRITE = 1019;
  public final static int WT_STAT_CONN_CACHE_BYTES_DIRTY = 1020;
  public final static int WT_STAT_CONN_CACHE_BYTES_INUSE = 1021;
  public final static int WT_STAT_CONN_CACHE_BYTES_MAX = 1022;
  public final static int WT_STAT_CONN_CACHE_BYTES_READ = 1023;
  public final static int WT_STAT_CONN_CACHE_BYTES_WRITE = 1024;
  public final static int WT_STAT_CONN_CACHE_EVICTION_CHECKPOINT = 1025;
  public final static int WT_STAT_CONN_CACHE_EVICTION_CLEAN = 1026;
  public final static int WT_STAT_CONN_CACHE_EVICTION_DEEPEN = 1027;
  public final static int WT_STAT_CONN_CACHE_EVICTION_DIRTY = 1028;
  public final static int WT_STAT_CONN_CACHE_EVICTION_FAIL = 1029;
  public final static int WT_STAT_CONN_CACHE_EVICTION_FORCE = 1030;
  public final static int WT_STAT_CONN_CACHE_EVICTION_FORCE_FAIL = 1031;
  public final static int WT_STAT_CONN_CACHE_EVICTION_HAZARD = 1032;
  public final static int WT_STAT_CONN_CACHE_EVICTION_INTERNAL = 1033;
  public final static int WT_STAT_CONN_CACHE_EVICTION_SLOW = 1034;
  public final static int WT_STAT_CONN_CACHE_EVICTION_SPLIT = 1035;
  public final static int WT_STAT_CONN_CACHE_EVICTION_WALK = 1036;
  public final static int WT_STAT_CONN_CACHE_PAGES_DIRTY = 1037;
  public final static int WT_STAT_CONN_CACHE_PAGES_INUSE = 1038;
  public final static int WT_STAT_CONN_CACHE_READ = 1039;
  public final static int WT_STAT_CONN_CACHE_WRITE = 1040;
  public final static int WT_STAT_CONN_COND_WAIT = 1041;
  public final static int WT_STAT_CONN_CURSOR_CREATE = 1042;
  public final static int WT_STAT_CONN_CURSOR_INSERT = 1043;
  public final static int WT_STAT_CONN_CURSOR_NEXT = 1044;
  public final static int WT_STAT_CONN_CURSOR_PREV = 1045;
  public final static int WT_STAT_CONN_CURSOR_REMOVE = 1046;
  public final static int WT_STAT_CONN_CURSOR_RESET = 1047;
  public final static int WT_STAT_CONN_CURSOR_SEARCH = 1048;
  public final static int WT_STAT_CONN_CURSOR_SEARCH_NEAR = 1049;
  public final static int WT_STAT_CONN_CURSOR_UPDATE = 1050;
  public final static int WT_STAT_CONN_DH_SESSION_HANDLES = 1051;
  public final static int WT_STAT_CONN_DH_SESSION_SWEEPS = 1052;
  public final static int WT_STAT_CONN_FILE_OPEN = 1053;
  public final static int WT_STAT_CONN_LOG_BUFFER_GROW = 1054;
  public final static int WT_STAT_CONN_LOG_BUFFER_SIZE = 1055;
  public final static int WT_STAT_CONN_LOG_BYTES_USER = 1056;
  public final static int WT_STAT_CONN_LOG_BYTES_WRITTEN = 1057;
  public final static int WT_STAT_CONN_LOG_MAX_FILESIZE = 1058;
  public final static int WT_STAT_CONN_LOG_READS = 1059;
  public final static int WT_STAT_CONN_LOG_SCAN_RECORDS = 1060;
  public final static int WT_STAT_CONN_LOG_SCAN_REREADS = 1061;
  public final static int WT_STAT_CONN_LOG_SCANS = 1062;
  public final static int WT_STAT_CONN_LOG_SLOT_CLOSES = 1063;
  public final static int WT_STAT_CONN_LOG_SLOT_CONSOLIDATED = 1064;
  public final static int WT_STAT_CONN_LOG_SLOT_JOINS = 1065;
  public final static int WT_STAT_CONN_LOG_SLOT_RACES = 1066;
  public final static int WT_STAT_CONN_LOG_SLOT_SWITCH_FAILS = 1067;
  public final static int WT_STAT_CONN_LOG_SLOT_TOOBIG = 1068;
  public final static int WT_STAT_CONN_LOG_SLOT_TOOSMALL = 1069;
  public final static int WT_STAT_CONN_LOG_SLOT_TRANSITIONS = 1070;
  public final static int WT_STAT_CONN_LOG_SYNC = 1071;
  public final static int WT_STAT_CONN_LOG_WRITES = 1072;
  public final static int WT_STAT_CONN_LSM_CHECKPOINT_THROTTLE = 1073;
  public final static int WT_STAT_CONN_LSM_MERGE_THROTTLE = 1074;
  public final static int WT_STAT_CONN_LSM_ROWS_MERGED = 1075;
  public final static int WT_STAT_CONN_MEMORY_ALLOCATION = 1076;
  public final static int WT_STAT_CONN_MEMORY_FREE = 1077;
  public final static int WT_STAT_CONN_MEMORY_GROW = 1078;
  public final static int WT_STAT_CONN_READ_IO = 1079;
  public final static int WT_STAT_CONN_REC_PAGES = 1080;
  public final static int WT_STAT_CONN_REC_PAGES_EVICTION = 1081;
  public final static int WT_STAT_CONN_REC_SKIPPED_UPDATE = 1082;
  public final static int WT_STAT_CONN_RWLOCK_READ = 1083;
  public final static int WT_STAT_CONN_RWLOCK_WRITE = 1084;
  public final static int WT_STAT_CONN_SESSION_CURSOR_OPEN = 1085;
  public final static int WT_STAT_CONN_TXN_BEGIN = 1086;
  public final static int WT_STAT_CONN_TXN_CHECKPOINT = 1087;
  public final static int WT_STAT_CONN_TXN_CHECKPOINT_RUNNING = 1088;
  public final static int WT_STAT_CONN_TXN_COMMIT = 1089;
  public final static int WT_STAT_CONN_TXN_FAIL_CACHE = 1090;
  public final static int WT_STAT_CONN_TXN_ROLLBACK = 1091;
  public final static int WT_STAT_CONN_WRITE_IO = 1092;
  public final static int WT_STAT_DSRC_ALLOCATION_SIZE = 2000;
  public final static int WT_STAT_DSRC_BLOCK_ALLOC = 2001;
  public final static int WT_STAT_DSRC_BLOCK_CHECKPOINT_SIZE = 2002;
  public final static int WT_STAT_DSRC_BLOCK_EXTENSION = 2003;
  public final static int WT_STAT_DSRC_BLOCK_FREE = 2004;
  public final static int WT_STAT_DSRC_BLOCK_MAGIC = 2005;
  public final static int WT_STAT_DSRC_BLOCK_MAJOR = 2006;
  public final static int WT_STAT_DSRC_BLOCK_MINOR = 2007;
  public final static int WT_STAT_DSRC_BLOCK_REUSE_BYTES = 2008;
  public final static int WT_STAT_DSRC_BLOCK_SIZE = 2009;
  public final static int WT_STAT_DSRC_BLOOM_COUNT = 2010;
  public final static int WT_STAT_DSRC_BLOOM_FALSE_POSITIVE = 2011;
  public final static int WT_STAT_DSRC_BLOOM_HIT = 2012;
  public final static int WT_STAT_DSRC_BLOOM_MISS = 2013;
  public final static int WT_STAT_DSRC_BLOOM_PAGE_EVICT = 2014;
  public final static int WT_STAT_DSRC_BLOOM_PAGE_READ = 2015;
  public final static int WT_STAT_DSRC_BLOOM_SIZE = 2016;
  public final static int WT_STAT_DSRC_BTREE_COLUMN_DELETED = 2017;
  public final static int WT_STAT_DSRC_BTREE_COLUMN_FIX = 2018;
  public final static int WT_STAT_DSRC_BTREE_COLUMN_INTERNAL = 2019;
  public final static int WT_STAT_DSRC_BTREE_COLUMN_VARIABLE = 2020;
  public final static int WT_STAT_DSRC_BTREE_COMPACT_REWRITE = 2021;
  public final static int WT_STAT_DSRC_BTREE_ENTRIES = 2022;
  public final static int WT_STAT_DSRC_BTREE_FIXED_LEN = 2023;
  public final static int WT_STAT_DSRC_BTREE_MAXIMUM_DEPTH = 2024;
  public final static int WT_STAT_DSRC_BTREE_MAXINTLITEM = 2025;
  public final static int WT_STAT_DSRC_BTREE_MAXINTLPAGE = 2026;
  public final static int WT_STAT_DSRC_BTREE_MAXLEAFITEM = 2027;
  public final static int WT_STAT_DSRC_BTREE_MAXLEAFPAGE = 2028;
  public final static int WT_STAT_DSRC_BTREE_OVERFLOW = 2029;
  public final static int WT_STAT_DSRC_BTREE_ROW_INTERNAL = 2030;
  public final static int WT_STAT_DSRC_BTREE_ROW_LEAF = 2031;
  public final static int WT_STAT_DSRC_CACHE_BYTES_READ = 2032;
  public final static int WT_STAT_DSRC_CACHE_BYTES_WRITE = 2033;
  public final static int WT_STAT_DSRC_CACHE_EVICTION_CHECKPOINT = 2034;
  public final static int WT_STAT_DSRC_CACHE_EVICTION_CLEAN = 2035;
  public final static int WT_STAT_DSRC_CACHE_EVICTION_DIRTY = 2036;
  public final static int WT_STAT_DSRC_CACHE_EVICTION_FAIL = 2037;
  public final static int WT_STAT_DSRC_CACHE_EVICTION_HAZARD = 2038;
  public final static int WT_STAT_DSRC_CACHE_EVICTION_INTERNAL = 2039;
  public final static int WT_STAT_DSRC_CACHE_OVERFLOW_VALUE = 2040;
  public final static int WT_STAT_DSRC_CACHE_READ = 2041;
  public final static int WT_STAT_DSRC_CACHE_READ_OVERFLOW = 2042;
  public final static int WT_STAT_DSRC_CACHE_WRITE = 2043;
  public final static int WT_STAT_DSRC_COMPRESS_RAW_FAIL = 2044;
  public final static int WT_STAT_DSRC_COMPRESS_RAW_FAIL_TEMPORARY = 2045;
  public final static int WT_STAT_DSRC_COMPRESS_RAW_OK = 2046;
  public final static int WT_STAT_DSRC_COMPRESS_READ = 2047;
  public final static int WT_STAT_DSRC_COMPRESS_WRITE = 2048;
  public final static int WT_STAT_DSRC_COMPRESS_WRITE_FAIL = 2049;
  public final static int WT_STAT_DSRC_COMPRESS_WRITE_TOO_SMALL = 2050;
  public final static int WT_STAT_DSRC_CURSOR_CREATE = 2051;
  public final static int WT_STAT_DSRC_CURSOR_INSERT = 2052;
  public final static int WT_STAT_DSRC_CURSOR_INSERT_BULK = 2053;
  public final static int WT_STAT_DSRC_CURSOR_INSERT_BYTES = 2054;
  public final static int WT_STAT_DSRC_CURSOR_NEXT = 2055;
  public final static int WT_STAT_DSRC_CURSOR_PREV = 2056;
  public final static int WT_STAT_DSRC_CURSOR_REMOVE = 2057;
  public final static int WT_STAT_DSRC_CURSOR_REMOVE_BYTES = 2058;
  public final static int WT_STAT_DSRC_CURSOR_RESET = 2059;
  public final static int WT_STAT_DSRC_CURSOR_SEARCH = 2060;
  public final static int WT_STAT_DSRC_CURSOR_SEARCH_NEAR = 2061;
  public final static int WT_STAT_DSRC_CURSOR_UPDATE = 2062;
  public final static int WT_STAT_DSRC_CURSOR_UPDATE_BYTES = 2063;
  public final static int WT_STAT_DSRC_LSM_CHECKPOINT_THROTTLE = 2064;
  public final static int WT_STAT_DSRC_LSM_CHUNK_COUNT = 2065;
  public final static int WT_STAT_DSRC_LSM_GENERATION_MAX = 2066;
  public final static int WT_STAT_DSRC_LSM_LOOKUP_NO_BLOOM = 2067;
  public final static int WT_STAT_DSRC_LSM_MERGE_THROTTLE = 2068;
  public final static int WT_STAT_DSRC_REC_DICTIONARY = 2069;
  public final static int WT_STAT_DSRC_REC_MULTIBLOCK_INTERNAL = 2070;
  public final static int WT_STAT_DSRC_REC_MULTIBLOCK_LEAF = 2071;
  public final static int WT_STAT_DSRC_REC_MULTIBLOCK_MAX = 2072;
  public final static int WT_STAT_DSRC_REC_OVERFLOW_KEY_INTERNAL = 2073;
  public final static int WT_STAT_DSRC_REC_OVERFLOW_KEY_LEAF = 2074;
  public final static int WT_STAT_DSRC_REC_OVERFLOW_VALUE = 2075;
  public final static int WT_STAT_DSRC_REC_PAGE_DELETE = 2076;
  public final static int WT_STAT_DSRC_REC_PAGE_MATCH = 2077;
  public final static int WT_STAT_DSRC_REC_PAGES = 2078;
  public final static int WT_STAT_DSRC_REC_PAGES_EVICTION = 2079;
  public final static int WT_STAT_DSRC_REC_PREFIX_COMPRESSION = 2080;
  public final static int WT_STAT_DSRC_REC_SKIPPED_UPDATE = 2081;
  public final static int WT_STAT_DSRC_REC_SUFFIX_COMPRESSION = 2082;
  public final static int WT_STAT_DSRC_SESSION_COMPACT = 2083;
  public final static int WT_STAT_DSRC_SESSION_CURSOR_OPEN = 2084;
  public final static int WT_STAT_DSRC_TXN_UPDATE_CONFLICT = 2085;
}