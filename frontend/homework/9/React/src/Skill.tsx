import './Main.css';
interface SkillsProps {
    skills: { id: number; skill: string }[];
  }

  
function Skill({skills}:SkillsProps) {
    return (
        <div className="skill-section">
          <h2 className="skill-heading">Skills:</h2>
          <ul className="skills-list">
            {skills.map((item) => (
              <li key={item.id}>{item.skill}</li>
            ))}
          </ul>
        </div>

        
      );
    };
    

export default Skill