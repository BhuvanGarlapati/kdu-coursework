
const express = require("express")
const cors = require("cors")
const socketio = require("socket.io")
const http = require("http")

const port = 5001;
const app = express();
const server = http.createServer(app);

app.use(cors());
app.use(express.json())

const io = new socketio.Server(server,{
    cors:{
        origin:"*"
    }
});


io.on("connection",(socket)=>{

    socket.join("stock-details");

    console.log("New user connected to Zomato stock room");

    setInterval(() => {
        const price = Math.floor((Math.random() * 500) + 1);
        io.to("stock-details").emit("stock-details", price)
        console.log("New price sent: " + price);
    }, 5000);

    socket.on("message",(payload)=>{
        console.log("payload:",payload);
        io.except(socket.id).emit('new-message',payload);
    })
})

server.listen(port, () => {
    console.log(`Running...`);
})

