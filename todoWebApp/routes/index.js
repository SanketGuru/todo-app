var express = require('express');
const repo = require('../data_repository/datarepo');
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
router.post( '/login', function (req, res, next) {
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
        
          if(data.password==req.body.password){
            response.message = "Go in app ";
            response.payload = data;
            res.json(response);
            return data;
          }else{
            response.status = false;
            response.message = "Invalid ";
            response.payload = {};
            res.json(response);
            return ;
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