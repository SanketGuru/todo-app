'use strict';
console.log('Importing Datarepo module');
var mongoose = require('mongoose');
//var mongoConnection='mongodb://localhost/my_database';


//export named module
exports.dataRepo = function () {
    mongoose.connect(mongoConnection);


    var mongo = mongoose.model('Todo', {
        text: {
            type: String,
            default: ''
        }
    });


    mongo.create({
        text:"Tesy",
        done: false
    }, function (err, todo) {
        if (err)
            res.send(err);

        // get and return all the todos after you create another
        getTodos(res);
    });

}