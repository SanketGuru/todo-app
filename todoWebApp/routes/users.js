var express = require('express');
var router = express.Router();
var mongoose = require('mongoose');
const repo = require('../data_repository/datarepo');
const noteControler = require('../controler/notesControler');
//https://coursework.vschool.io/mongoose-crud/
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
router.route('/createnote').put(noteControler.createNote);


/**
 * get My Notes
*/
router.route('/notes/:owner').get(noteControler.getNotes);

/**
 * get My Notes
*/
router.route('/notes/page/:owner').get(noteControler.getNotesByPagieng);


/**
 * edit Notes
*/
router.route('/editnote').patch(noteControler.editNote);

/**
 * edit Notes
*/
router.route('/note').delete(noteControler.deleteNote);

module.exports = router;
