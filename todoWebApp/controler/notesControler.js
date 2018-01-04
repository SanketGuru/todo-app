var mongoose = require('mongoose');
const repo = require('../data_repository/datarepo');
var response = {
  status: true,
  message: "",
  payload: {}
}
var notesController = {//start notesController
  getNotesByPagieng: function (req, res, next) {
    var userId = req.headers.id;
    console.log(req.params.pageNumber);
    var pagenumber = parseInt(req.params.pageNumber);
    var pagesize = 15;
    //TODO : handel error
    //  var pagenumber = req.body.pagenumber;
    // console.log("Hijsnslnasnk");
    var Notes = mongoose.model('Notes', repo.dataRepo.NotesSchema);
    var query = {};
    Notes.count(query, (err, cnt) => {
      if (err) { }
      //var totalCount=cnt;
      var queryObj = Notes.find(query).limit(pagesize).skip(pagesize * (pagenumber - 1));
      // console.log(cnt);
      queryObj.exec((err1, noteList) => {
        if (err1) { }
        var data = { pageSize: pagesize, pageNumber: pagenumber + 1, totalCount: cnt, list: noteList };
        response.status = true;
        response.payload = data;
        response.message = " Got page";
        res.json(response)
      })

    });

  },
  //this is where you return
  createNote: function (req, res, next) {

    try {
      //   console.log('head '+ req.headers.id);
      //   console.log('Notes '+JSON.stringify(req.body));
      //  var Note = JSON.parse(req.body.note);
      var Note = req.body.note;

      //removeing _id
      delete Note._id;


      var userId = req.headers.id;
      // console.log(userId);
      //var notesCon = repo.dataRepo.NotesCollection;
      var Notes = mongoose.model('Notes', repo.dataRepo.NotesSchema);
      Note.ownerId = userId;



      //  console.log(JSON.stringify(Note));
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
        console.log(JSON.stringify(response));
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
  },
  editNote: function (req, res, next) {

    try {
      console.log(req.body._id);
      // var body = JSON.parse(req.body);
      var userId = req.headers.id;

      //,{text :"hsjhshs"}, { multi: true }
      var Notes = mongoose.model('Notes', repo.dataRepo.NotesSchema);
      var note = JSON.parse(req.body.note);
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

  }
  ,
  deleteNote: function (req, res, next) {

    try {
      var Notes = mongoose.model('Notes', repo.dataRepo.NotesSchema);
      var id_arr = JSON.parse(req.body.id);
      console.log(id_arr);
      if (id_arr) { } else { id_arr = []; }
      Notes.remove(
        { "_id": { $in: id_arr } }

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

  }//end of deleteNote
  ,
  getNotes: function (req, res, next) {

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
  }//end of getNotes

};//end notesController
module.exports = notesController;