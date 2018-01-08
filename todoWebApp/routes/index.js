var express = require('express');
const repo = require('../data_repository/datarepo');
var mongoose = require('mongoose');
var router = express.Router();

var response = {
  status: true,
  message: "",
  payload: {}
}


/* GET home page. */
// router.get('/', function (req, res, next) {
//   res.render('index', { title: 'Express' });
// });

/*login Api*/
router.post('/login', function (req, res, next) {
  var userCon = repo.dataRepo.Usercollection;
  try {
    var ss = userCon.findOne({ 'userName': req.body.userName }, 'userName password', function (err, data) {
      if (err) {
        response.status = false;
        response.message = "Some thing went wrong" + err;
        response.payload = data;
        res.json(response);
        return 400;
      }
      else {
        if (data) {

          if (data.password == req.body.password) {
            response.status = true;
            response.message = "Go in app ";
            response.payload = data;
            console.log(response);
            res.status(200).send(response);
            return data;
          } else {
            response.status = false;
            response.message = "Invalid ";
            response.payload = {};
            res.status(200).send(response);
            return;
          }

        }
        else {
          response.status = false;
          response.message = "No such user found";
          response.payload = data;
          res.json(response);
          return data;
        }
      }
    });
  } catch (e) {
    console.log(e);
    response.status = false;
    response.message = "Some thing went wrong" + e;
    response.payload = data;
    res.json(response);
  }
});
/*Register Api*/
router.post('/register', function (req, res, next) {
  var userCon = repo.dataRepo.Usercollection;
  try {
    var User = mongoose.model('User', repo.dataRepo.UserShcema);
    var myObj = {
      userName: req.body.userName,
      password: req.body.password
    };
    console.log("My obj " + JSON.stringify(myObj));
    var Userdata = new User(myObj);
   // console.log(JSON.stringify(Userdata));
    Userdata.save((err, data) => {
      if (err) {
        response.status = false;
        response.message = "Some thing went wrong" + err;
        response.payload = data;
        res.json(response);
        return 400;
      }
      console.log(data);
      response.status = true;
      response.message = "Go in app ";
      response.payload = data;
      console.log(response);
      res.status(200).send(response);
      return data;
    });

  } catch (e) {
    console.log(e);
    response.status = false;
    response.message = "Some thing went wrong" + e;
    response.payload = data;
    res.json(response);
  }
});

/*find UserApi*/
router.get('/find/:user', function (req, res, next) {
  var userCon = repo.dataRepo.Usercollection;
  try {
    var ss = userCon.find({ 'userName': new RegExp('^'+req.params.user+'*', "i")}, 'userName password', function (err, data) {
      if (err) {
        response.status = false;
        response.message = "Some thing went wrong" + err;
        response.payload = data;
        res.json(response);
        return 400;
      }
      else {
        if (data) {

          if (data.password == req.body.password) {
            response.status = true;
            response.message = "Go in app ";
            response.payload = data;
            console.log(response);
            res.status(200).send(response);
            return data;
          } else {
            response.status = false;
            response.message = "Invalid ";
            response.payload = {};
            res.status(200).send(response);
            return;
          }

        }
        else {
          response.status = false;
          response.message = "No such user found";
          response.payload = data;
          res.json(response);
          return data;
        }
      }
    });
  } catch (e) {
    console.log(e);
    response.status = false;
    response.message = "Some thing went wrong" + e;
    response.payload = data;
    res.json(response);
  }
});

module.exports = router;
