
const repo = require('../data_repository/datarepo');

function findYou( ysername){
    try {
        var userCon = repo.dataRepo.Usercollection;
        var dataP = userCon.findOne({ 'userName': ysername }, 'userName password', function(err,person ){
    
            console.log("Hi jsancnd"+person.userName);
            return person;
                })
        ;
    
    
        return dataP;
    } catch (e) {
        console.log("eception" + e);
        return e;
    }
}

var ss=findYou("yo");
console.log("Test :"+ss.userName);
var ss3=0;