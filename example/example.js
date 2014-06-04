var levelup = require('levelup')
  , db = levelup('/tmp/test', { db: require('../') })
// If this were code outside of the node wiredtigerdown implementation, this
// would be:
//  , db = levelup('/tmp/test', { db: require('wiredtigerdown') })

db.put('name', 'Yuri Irsenovich Kim')
db.put('dob', '16 February 1941')
db.put('spouse', 'Kim Young-sook')
db.put('occupation', 'Clown')

db.readStream()
  .on('data', console.log)
  .on('close', function () { console.log('Show\'s over folks!') })
