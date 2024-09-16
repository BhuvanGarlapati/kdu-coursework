const express =  require('express');
const router = express.Router();
const member = require('../data');
const uuid = require('uuid');

const idFilter = req => members => members.id === req.params.id;

router.get('/',(req,res)=>{
    res.json(member);
});

router.get('/:id',(req,res) =>{
    const search_id = req.params.id;
    const memebers = member.filter((x) => x.id === search_id);

    res.json(memebers[0]);
} );


router.post('/', (req,res)=>{
    const members = {
        "id": uuid.v4(),
        "name": req.body.name,
        "tweet":req.body.tweet
    }
    if( !members.name){
        return res.status(400).json({msg: 'Missing name field'})
    };
    member.push(members);
    res.status(201).json(member);
});


// Update Member
router.put('/:id', (req, res) => {
    const found = member.some(idFilter(req));
  
    if (found) {
      member.forEach((members, i) => {
        if (idFilter(req)(members)) {
  
          const updMember = {...members, ...req.body};
          member[i] = updMember
          res.json({ msg: 'Member updated', updMember });
        }
      });
    } else {
      res.status(400).json({ msg: `No member with the id of ${req.params.id}` });
    }
  });
  
  // Delete Member
  router.delete('/:id', (req, res) => {
    const found = member.some(idFilter(req));
  
    if (found) {
      res.json({
        msg: 'Member deleted',
        member: member.filter(members => !idFilter(req)(members))
      });
    } else {
      res.status(400).json({ msg: `No member with the id of ${req.params.id}` });
    }
  });


module.exports = router;
