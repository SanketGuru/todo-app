'use strict';
//https://darrenderidder.github.io/talks/ModulePatterns/#/
const Hapi = require('hapi');
const routes = require('.app/routes/routes');
const repo = require('.app/data_repository/datarepo');
// Create a server with a host and port
const server = Hapi.server({ 
    host: 'localhost', 
    port: 8000 
});
//Routes.server=server;
routes.routes(server);
// Add the route
server.route({
    method: 'GET',
    path:'/hello', 
    handler: function (request, h) {

        return 'hello world';
    }
});

// Start the server
async function start() {

    try {
        await server.start();
    }
    catch (err) {
        console.log(err);
        process.exit(1);
    }

    console.log('Server running at:', server.info.uri);
};

//start();
repo.dataRepo();