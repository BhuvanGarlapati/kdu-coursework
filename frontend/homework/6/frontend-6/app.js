const express =  require('express');
const logger = require('./middleware/logger');

const app = express();

const path = require('path');
const member = require('./data');

app.use(express.json());
app.use(express.urlencoded({ extended: false }));


app.use('/api/members', require('./api/member'));




//static file
app.use(express.static(path.join(__dirname,'public')));


const PORT = process.env.PORT || 5099;
app.listen(PORT, ()=> console.log(`Server Running ${PORT}`));