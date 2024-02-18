
const express = require('express');
const cors = require('cors');
const http = require('http');
const socketIo = require('socket.io');
const formatMessage = require("./message");

const app  = express();

app.use(express.json());
app.use(cors());
const server = http.createServer(app);
const io = new socketIo.Server(server,{
    cors:{
        origin:'*'
    }
});
const hardcodedUsers = [
    {
        "id": "1",
        "user_name": "Bhuavn",
        "user_email_id": "garlabhuvan@gmail.com",
        "password": "bhuvan",
        "profile_url": "https://example.com/johndoe"
    },
    {
        "id": "2",
        "user_name": "Akash",
        "user_email_id": "akash@gmail.com",
        "password": "akash",
        "profile_url": "https://example.com/johndoe"
    }
   
];

app.get('/', (req,res)=>{
    res.json('hello')
});

io.on('connection',(socket) =>{
    console.log('Connected');

    socket.on("message", (payload)=>{
        io.except(socket.id).emit('new-message',formatMessage(hardcodedUsers[0].user_name,payload));
    });

});

server.listen(3000,()=>{
    console.log('Server running')
});
