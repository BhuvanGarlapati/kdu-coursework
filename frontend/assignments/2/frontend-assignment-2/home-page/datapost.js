const registeredUsers = require("./datapost");

let posts = [
    {
        id: "post1",
        username: "bhuvan",
        firstname: registeredUsers["bhuvan"].name,
        timestamp: getRandomTimestamp(),
        message: "Hi this is Musk",
        profileImg: "https://example.com/johndoe"
    },
    {
        id: "post2",
        username: "akash",
        firstname: registeredUsers["akash"].name,
        timestamp: getRandomTimestamp(),
        message: "hello twitter",
        profileImg: "https://example.com/johndoe"
    }];
    function getRandomTimestamp() {
        const currentTime = new Date().getTime();
        const randomTimeDifference = Math.floor(Math.random() * 30 * 24 * 60 * 60 * 1000);
        const randomTimestamp = new Date(currentTime - randomTimeDifference).toISOString();
        return randomTimestamp;
    }

    posts.sort((a, b) => new Date(b.timestamp) - new Date(a.timestamp));
module.exports = posts;      