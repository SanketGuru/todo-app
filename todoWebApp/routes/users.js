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

router.put('/createnote', function (req, res, next) {
  /*
  {
id:id,
onerid:""
title:"",
type:"",
text:"",
status:<0,1,3>,
sharedWith:[
<Will keep ids of shared user>{
userid:id,
shareMode:<readOnly 0, write 1>
}
],
creationDate: date of creation,
dobyDate: date by which,
lastEdited:date
}*/
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
        response.payload = noteData;

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

module.exports = router;
