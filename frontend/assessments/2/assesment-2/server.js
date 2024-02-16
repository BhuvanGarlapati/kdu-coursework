const express = require('express');
const cors = require('cors');
const http = require('http');
const socketIo = require('socket.io');
const stocks=require('./stock-data');
const moment=require('moment');

const app  = express();

app.use(express.json());
app.use(cors());
const server = http.createServer(app);
const io = new socketIo.Server(server,{
    cors:{
        origin:'*'
    }
});

app.get('/', (req,res)=>{
    res.json('hello')
});
// app.use(express.static(path.join(__dirname,'public')));



io.on('connection',(socket) =>{
    console.log('Connected');

    socket.on("message", (payload)=>{
        console.log("Payload",payload);
        io.emit("new-message",payload);
        // io.except(socket.id).emit('new-message',payload);
       
    });
    io.emit("stock-details",stocks);
    console.log(stocks);

});

server.listen(3001,()=>{
    console.log('Server running')
});
