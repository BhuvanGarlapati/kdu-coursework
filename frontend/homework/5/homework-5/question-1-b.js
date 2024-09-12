const http = require('http');
const fs = require('fs');
const os = require('os');
const path = require('path');
const process = require('process');
const { execSync } = require('child_process');
const { isUtf8 } = require('buffer');


const server = http.createServer((req,res)=>{
    if(req.method === 'GET' && req.url === '/'){
        try{
            const systeminfo = fs.readFileSync('systeminfo.json', 'utf-8');
            const response = `Hello, my name is Bhuvan G!\n\nHere is my system information:\n\n${systeminfo}`;
            res.writeHead(200, { 'Content-Type': 'text/plain' });
            res.end(response);
        }catch (error) {
            res.writeHead(404, { 'Content-Type': 'text/plain' });
            res.end('File Not Found');
        }
    }else {
        res.writeHead(404, { 'Content-Type': 'text/plain' });
        res.end('Not Found');
    }
});

const PORT = 5009;
server.listen(PORT, () => {
    console.log(`Server is running on http://localhost:${PORT}/`);
});