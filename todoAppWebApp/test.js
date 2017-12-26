var userName = "yo";
var password = "ss";
const repo = require('./app/data_repository/datarepo');
//console.log("Finding " + userName);
var userCon = repo.dataRepo.Usercollection;

//      userCon.count({}, function(err, c) {
//         console.log('Count is ' + c);
//    });
var got = userCon.findOne({ 'userName': userName }, 'userName password', function (err, person) {
    if (err) {
        return 400;
    }


    console.log("Got data "+person);
    var dd={};
    dd.ff=44;
    console.log(JSON+"Got data "+person);
    return dd;
})

console.log(got);