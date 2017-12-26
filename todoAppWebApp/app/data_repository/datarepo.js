'use strict';
//How to spese fy momgous schema
//http://mongoosejs.com/docs/schematypes.html

//region Imports
console.log('Importing Datarepo module');
var config=require('../config/config')
var mongoose = require('mongoose');
//endregion

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
        text: "Tesy",
        done: false
    }, function (err, todo) {
        if (err)
            res.send(err);

        // get and return all the todos after you create another
        getTodos(res);
    });

}

//Schema for user table
var userSchema = new Schema( {
    userName: {
        type: String,
        default: ''
    },
    password: {
        type: String,
        default: ''
    },
    accessToken: {
        type: Array,
        default: []
    },
    userSince: {
        type: Date,
        default: Date.now
    }
});
var User = mongoose.model('User',userSchema);

//Schema for user table
var notesSchema = new Schema({
    ownerId: {
        type: String,
        default: ''
    },
    title: {
        type: String,
        default: ''
    },
    text: {
        type: String,
        default: ''
    },
    type: {
        type: Number,
        default: 0,
        min: 0,
        max: 3
    },
    status: {
        type: Number,
        default: 0,
        min: 0,
        max: 3
    },
    sharedWith: {
        type: Array,
        default: []
    },
    creationDate: {
        type: Date,
        default: Date.now
    },
    lastEdited: {
        type: Date,
        default: Date.now
    },
    doByDate: {
        type: Date,
        default: Date.now
    }
});
var Notes = mongoose.model('Notes', notesSchema);

