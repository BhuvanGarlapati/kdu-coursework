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
        origin:'http://127.0.0.1:5500'
    }
});

app.get('/', (req,res)=>{
    res.json('hello')
});
// app.use(express.static(path.join(__dirname,'public')));
let stockPrice = 0;
function pricechange(){
    setInterval(() => {
    const priceChange = Math.floor((Math.random() * 1000) - 500) ;
 stockPrice += priceChange;
    io.emit('price-update', {
    timeInterval: new Date().toLocaleTimeString(),
    priceChange: priceChange,
        })
    }, 5000);
}


pricechange()
server.listen(3001,()=>{
    console.log('Server running')
});
