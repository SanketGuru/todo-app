var express = require('express');
var router = express.Router();
var mongoose = require('mongoose');
const repo = require('../data_repository/datarepo');
/* GET users listing. */
router.get('/', function (req, res, next) {
  res.send('respond with a resource');
});
var response = {
  status: true,
  message: "",
  payload: {}
}
/**
 * Create new Note
*/
router.put('/createnote', function (req, res, next) {

  try {
    var Note = JSON.parse(req.body.note);

    var userId = req.headers.id;
    console.log(userId);
    //var notesCon = repo.dataRepo.NotesCollection;
    var Notes = mongoose.model('Notes', repo.dataRepo.NotesSchema);
    Note.ownerId = userId;
    console.log(JSON.stringify(Note));
    var notesData = new Notes(Note);
    notesData.save(function (err, noteData) {
      if (err) {
        //  console.log(err);
        response.status = false;
        response.message = "Some thing went wrong" + err;
        response.payload = {};

      } else {
        response.status = true;
        response.message = 'New Note created';
        response.payload = noteData._id;

      }
      res.json(response);
      //   res.send('respond with a resource');

    });
  } catch (e) {
    console.log(e);
    response.status = false;
    response.message = "Some thing went wrong" + e;
    response.payload = e;
    res.json(response);
  }
});


/**
 * get My Notes
*/
router.get('/notes/:owner', function (req, res, next) {

  try {
    //var body = JSON.parse(req.body);
    var userId = req.headers.id;
    console.log(req.params.owner);

    //var notesCon = repo.dataRepo.NotesCollection;
    var Notes = mongoose.model('Notes', repo.dataRepo.NotesSchema);
    Notes.find({}, function (err, noteData) {
      if (err) {
        response.status = false;
        response.message = "Some thing went wrong";
        response.payload = {};

      } else {
        response.status = true;
        response.message = "List Of Notes";
        response.payload = noteData;

      }

    });
  } catch (e) {
    console.log(e);
    response.status = false;
    response.message = "Some thing went wrong" + e;
    response.payload = {};
  }
  res.json(response);
});


/**
 * edit Notes
*/
router.post('/editnote', function (req, res, next) {

  try {
    console.log(req.body._id);
    // var body = JSON.parse(req.body);
    //var userId = req.headers.id;

    //,{text :"hsjhshs"}, { multi: true }
    var Notes = mongoose.model('Notes', repo.dataRepo.NotesSchema);
    var note =JSON.parse(req.body.note);
    Notes.update(
      {
        "_id": req.body._id
      }, note,
       { multi: true }
      , function (err, noteData) {
        if (err) {
          response.status = false;
          response.message = "Some thing went wrong" + err;
          response.payload = err;

        } else {

          response.status = true;
          response.message = "List Of Notes";
          response.payload = noteData;

        }
        res.json(response);
      });
  } catch (e) {
    console.log(e);
    response.status = false;
    response.message = "Some thing went wrong" + e;
    response.payload = {};
    res.json(response);
  }

});

/**
 * edit Notes
*/
router.delete('/note', function (req, res, next) {
//TODO : this routs must delet multiple data records passed to it in array 
  try {

  //,{text :"hsjhshs"}, { multi: true }
    var Notes = mongoose.model('Notes', repo.dataRepo.NotesSchema);
    var id_arr =JSON.parse(req.body.id);
    console.log(id_arr);
    if(id_arr){}else{id_arr=[];}
    Notes.findByIdAndRemove(
    { $in :id_arr}
      ,{ multi: true }
      , function (err, noteData) {
        if (err) {
          response.status = false;
          response.message = "Some thing went wrong" + err;
          response.payload = err;

        } else {

          response.status = true;
          response.message = "Note Deleted";
          response.payload = noteData;
          
        }
        res.json(response);
      });
  } catch (e) {
    console.log(e);
    response.status = false;
    response.message = "Some thing went wrong" + e;
    response.payload = {};
    res.json(response);
  }

});
module.exports = router;
