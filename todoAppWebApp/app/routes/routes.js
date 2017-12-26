
const repo = require('../data_repository/datarepo');
//https://www.cronj.com/blog/hapi-mongoose/
//console.log('Importing routes module');

//export un named module
// module.exports = function () {
//     console.log('bar!');
//   }

//export named module
exports.routes = function (server) {
    //  console.log('Setting Routes');

    server.route({
        method: 'POST',
        path: '/api/v1/login',
        handler: function (request, hedder) {
            var userName = request.payload.userName;
            var password = request.payload.password;
            console.log("Finding " + request.payload);
            var userCon = repo.dataRepo.Usercollection;

            try {
                var dataP = userCon.findOne({ 'userName': userName }, 'userName password', function (err, person) {
                    if (err) {
                        return 400;
                    }
                    person.error="No";
                    return person;

                });

              var  reo = {};
                reo.per = dataP;
                return dataP;
            } catch (e) {
                console.log("eception" + e);
                return e;
            }
            // return got.userName;
            //   userCon.create({
            //             userName: userName,
            //             password: password,
            //             done: false
            //         }, function (err, todo) {
            //             if (err)
            //                 res.send(err);

            //             // get and return all the todos after you create another
            //             getTodos(res);
            //      });
            // return {
            //     status: true,
            //     data: null,
            //     message: "Something went wrong"

        }
    });
}