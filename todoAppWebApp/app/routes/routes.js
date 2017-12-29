
const repo = require('../data_repository/datarepo');
//https://www.cronj.com/blog/hapi-mongoose/
//console.log('Importing routes module');

//export un named module
// module.exports = function () {
//     console.log('bar!');
//   }
function reply(data) {
    data.re = 234;
    return data;
}
//export named module
exports.routes = function (server) {
    //  console.log('Setting Routes');

    server.route({
        method: 'POST',
        path: '/api/v1/login',
        handler: function (request, h) {
            var userName = request.payload.userName;
            var password = request.payload.password;
            var userCon = repo.dataRepo.Usercollection;

            try {
                var ss = userCon.findOne({ 'userName': userName }, 'userName password', function (err, data) {
                    if (err) {
                        return 400;
                    }
                    return data;

                });

            } catch (e) {
                console.log("eception" + e);
                return e;
            }
        
        }
    });
}