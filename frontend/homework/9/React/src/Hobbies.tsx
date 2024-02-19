import './Main.css';
interface HobbiesProps {
    hobbies: { id: number; 
        hobby: string 
    }[];
  }
  

function Hobbies({hobbies}:HobbiesProps) {
  return (
   <>
   <div className="hobbies-section">
    <h2 className="skill-heading">Hobbies:</h2>
    <ul className="skills-list">
        {hobbies.map((item)=>
        <li key={item.id}>{item.hobby}</li>
        )}
    </ul>
   </div>
   </>
  )
}

export default Hobbies