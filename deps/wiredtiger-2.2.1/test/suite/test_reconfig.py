#!/usr/bin/env python
#
# Public Domain 2008-2014 WiredTiger, Inc.
#
# This is free and unencumbered software released into the public domain.
#
# Anyone is free to copy, modify, publish, use, compile, sell, or
# distribute this software, either in source code form or as a compiled
# binary, for any purpose, commercial or non-commercial, and by any
# means.
#
# In jurisdictions that recognize copyright laws, the author or authors
# of this software dedicate any and all copyright interest in the
# software to the public domain. We make this dedication for the benefit
# of the public at large and to the detriment of our heirs and
# successors. We intend this dedication to be an overt act of
# relinquishment in perpetuity of all present and future rights to this
# software under copyright law.
#
# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
# EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
# MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
# IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
# OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
# ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
# OTHER DEALINGS IN THE SOFTWARE.

import wiredtiger, wttest

# test_reconfig.py
#    Smoke-test the connection reconfiguration operations.
class test_reconfig(wttest.WiredTigerTestCase):

    def test_reconfig_shared_cache(self):
        self.conn.reconfigure("shared_cache=(name=pool,size=300M)")

    def test_reconfig_async(self):
        # Async starts off.  Reconfigure through all the various cases, each
        # building from the previous state.
        # Async is off, and remains off.
        self.conn.reconfigure("async=(enabled=false)")
        # Async is off, turn it on.
        self.conn.reconfigure("async=(enabled=true)")
        # Async is on, and remains on.
        self.conn.reconfigure("async=(enabled=true)")
        # Async is on, turn it off.
        self.conn.reconfigure("async=(enabled=false)")
        # Async is off, turn it on with ops_max and threads.
        self.conn.reconfigure("async=(enabled=true,ops_max=512,threads=10)")
        # Reconfigure and use same thread count. (no-op)
        self.conn.reconfigure("async=(threads=10)")
        # Reconfigure more threads.
        self.conn.reconfigure("async=(threads=14)")
        # Reconfigure fewer threads.
        self.conn.reconfigure("async=(threads=8)")
        # Reconfigure illegal ops_max (ignored).
        self.conn.reconfigure("async=(ops_max=1024)")
        # Turn async off.
        self.conn.reconfigure("async=(enabled=false)")
        # Async is off, turn it on.  Should end up with the
        # same ops_max of 512 and thread of 8.
        self.conn.reconfigure("async=(enabled=true)")

    def test_reconfig_statistics(self):
        self.conn.reconfigure("statistics=(all)")
        self.conn.reconfigure("statistics=(fast)")
        self.conn.reconfigure("statistics=(none)")

    def test_reconfig_checkpoints(self):
        self.conn.reconfigure("checkpoint=(wait=0)")
        self.conn.reconfigure("checkpoint=(wait=5)")
        self.conn.reconfigure("checkpoint=(wait=0,name=hi)")
        self.conn.reconfigure("checkpoint=(wait=5,name=hi)")

    def test_reconfig_stat_log(self):
        self.conn.reconfigure("statistics=[all],statistics_log=(wait=0)")
        self.conn.reconfigure("statistics_log=(wait=0)")
        self.conn.reconfigure("statistics_log=(wait=2)")
        self.conn.reconfigure("statistics_log=(wait=0)")
        self.conn.reconfigure("statistics_log=(wait=2,sources=[lsm:])")
        self.conn.reconfigure("statistics_log=(wait=0)")
        self.conn.reconfigure("statistics_log=(wait=2,timestamp=\"t%b %d\")")
        self.conn.reconfigure("statistics_log=(wait=0)")
        self.conn.reconfigure("statistics_log=(wait=2,path=\"wts.%d.%H\")")
        self.conn.reconfigure("statistics_log=(wait=0)")
        self.conn.reconfigure(
             "statistics_log=(wait=2,sources=[lsm:],timestamp=\"%b\")")

if __name__ == '__main__':
    wttest.run()
