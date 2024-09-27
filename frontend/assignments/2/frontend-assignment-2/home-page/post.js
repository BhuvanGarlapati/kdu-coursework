const express = require('express');
const router = express.Router();
const posts = require("./datapost");
const registeredUsers = require("./userdata");

router.get("/:pageSize/:page", (req, res) => {
    const pageSize = parseInt(req.params.pageSize); 
    const page = parseInt(req.params.page); 

    const startIndex = (page - 1) * pageSize;
    const endIndex = page * pageSize;

    const paginatedPosts = posts.slice(startIndex, endIndex);

    res.json(paginatedPosts);
});


router.get("/:id", (req, res) => {
    const postId = req.params.id;
    const post = posts.find(post => post.id === postId);

    if (!post) {
        return res.status(404).json({ message: "Post is found here" });
    }

    res.json(post);
});


router.post("/", (req, res) => {
    const { username, timestamp, message, img } = req.body;

    if (!username || !timestamp || !message) {
        return res.status(400).json({ message: "All fields are required" });
    }

    const newPost = {
        id: `post${posts.length + 1}`,
        username,
        timestamp,
        message,
        img
    };

    const user = registeredUsers[username];

    if (!user) {
        return res.status(404).json({ message: "User not found" });
    }

    const updatedPost = {
        ...newPost,
        firstname: user.name,
        profileImg: user.profile_url
    };

    posts.unshift(updatedPost);
    res.status(201).json({ message: "Post has been added sucessfully by user", post: updatedPost });
});

module.exports = router;
