'use strict';
console.log('Importing Datarepo module');
var config=require('../config/config')
var mongoose = require('mongoose');

var mongoConnection=config.remoteUrl;


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