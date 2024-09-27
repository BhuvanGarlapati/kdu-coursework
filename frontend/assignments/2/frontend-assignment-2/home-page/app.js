const express = require('express');
const cors = require('cors');
const http = require('http');
const socketIo = require('socket.io');
const path = require('path');
const bodyParser = require('body-parser');

const app = express();

app.use(cors());
app.use(express.json());

// Serve static files from the 'public' directory
app.use(express.static(path.join(__dirname, 'public')));

const server = http.createServer(app);
const io = new socketIo.Server(server, {
    cors: {
        origin: 'http://127.0.0.1:5502'
    }
});

// Array to store multiple hardcoded user details
const hardcodedUsers = [
    { username: 'bhuvan', password: 'bhuvan' },
    { username: 'user2', password: 'password2' },
    // Add more users as needed
];

app.post("/api/user/login", (req, res) => {
    const { username, password } = req.body;

    // Check if the provided credentials match any user in the array
    const isValidUser = hardcodedUsers.some(user => user.username === username && user.password === password);

    if (isValidUser) {
        res.json({ success: true, message: "Login successful" });
    } else {
        res.json({ success: false, message: "Invalid credentials" });
    }
});



app.use('/', express.static(path.join(__dirname, 'public')));

io.on('connection', (socket) => {
    console.log('A user connected');

    // Send random data to the client every 5 seconds
    const randomDataInterval = setInterval(() => {
        const randomData = Math.random();
        socket.emit('randomData', randomData);
    }, 5000);

    // Handle disconnection
    socket.on('disconnect', () => {
        clearInterval(randomDataInterval);
        console.log('A user disconnected');
    });
});


app.get("/", (req, res) => {
    res.json({
        msg: "Hello--Connected"
    });
});

server.listen(8000, () => {
    console.log("Running................");
});