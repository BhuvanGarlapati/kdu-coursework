const express = require('express');
const cors = require('cors');
const http = require('http');
const socketIo = require('socket.io');

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
// check the connection
io.on('connection',(socket) =>{
    console.log('Connected');

    socket.on("message", (payload)=>{
        console.log("Payload",payload);
        // io.emit("new-message",payload);
        io.except(socket.id).emit('new-message',payload);
       
    });

});

server.listen(3000,()=>{
    console.log('Server running')
});
