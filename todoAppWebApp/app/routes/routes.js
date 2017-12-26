'use strict';
//console.log('Importing routes module');

//export un named module
// module.exports = function () {
//     console.log('bar!');
//   }

//export named module
exports.routes = function (server) {
  //  console.log('Setting Routes');
    server.route({
        method: 'GET',
        path:'/hello2', 
        handler: function (request, hedder) {
    
            return 'hello world2';
        }
    });
  }