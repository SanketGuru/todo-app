var restify = require('restify');

const repo = require('./app/data_repository/datarepo');

function respond(req, res, next) {
 // res.send('hello ' + req.params.userName);

  var userCon = repo.dataRepo.Usercollection;

  try {
   // var jsonBody = JSON.parse(req.body);
    console.log(req._body);
      var ss = userCon.findOne({ 'userName': "yo" }, 'userName password', function (err, data) {
          if (err) {
              return 400;
          }
        
          console.log("Fonnds "+data.userName);
      //    data["prity"]="gold";
          var sata={
              dfsd:"dsfsd",
              mota: data
          }
          res.send( sata);
          next();
          return data;
      });

  } catch (e) {
      console.log("eception" + e);
      return e;
  }

}

var server = restify.createServer();
//server.use(restify.plugins.bodyParser()); 
server.get('/hello/:name', respond);
server.post('/api/v1/login', respond);

server.listen(8000, function() {
  console.log('%s listening at %s', server.name, server.url);
});