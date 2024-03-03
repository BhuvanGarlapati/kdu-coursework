
import cors from "cors";
import { Server } from "socket.io";
import { createServer } from "http";
import express, { json } from 'express';
const port = 5001;
const app = express();
const server = createServer(app);

app.use(cors());
app.use(json())

const io = new Server(server,{
    cors:{
        origin:"*"
    }
});


io.on("connection",(socket)=>{

    socket.on("message",(payload)=>{
        console.log("payload:",payload);
        io.except(socket.id).emit('new-message',payload);
    })
})

server.listen(port, () => {
    console.log(`Server is connected: http://localhost:${port}`);
})


