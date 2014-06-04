{
    "targets": [{
      "target_name": "leveldown"
      , "include_dirs"  : [
            "<!(node -e \"require('nan')\")"
        ]
      , "link_settings": {
        "libraries": [ "../lib/libwiredtiger_leveldb.a"
          , "../lib/libwiredtiger.a" ]
      }
      , "sources": [
            "src/batch.cc"
          , "src/batch_async.cc"
          , "src/database.cc"
          , "src/database_async.cc"
          , "src/iterator.cc"
          , "src/iterator_async.cc"
          , "src/leveldown.cc"
          , "src/leveldown_async.cc"
        ]
    }]
}
