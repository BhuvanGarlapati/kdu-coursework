
import './App.css';
import Profile from './Profile';

const jsonData = {
  "name": "Amey",
  "fullName": "Amey Aditya",
  "qualification": "SSE",
  "skills": [
      {
          "id": 1,
          "skill": "Python"
      },
      {
          "id": 2,
          "skill": "React"
      }
  ],
  "hobbies": [
      {
          "id": 1,
          "hobby": "Cricket"
      },{
        "id": 2,
        "hobby": "Table Tennis"
    }
  ]
};

function App() {
  return (
    <>
    <Profile data={jsonData}/>
    </>
    
  );
}

export default App;
