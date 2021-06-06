var http = require('http');

RC_HOST = "0.0.0.0";
RC_PORT = 8083;

http.createServer(function (req, res) {
    console.log('Received: ' + req.url);
    res.writeHead(200);
    res.end();
}).listen(RC_PORT, RC_HOST);
console.log('Server running at http://'+RC_HOST+':'+RC_PORT+'/');
