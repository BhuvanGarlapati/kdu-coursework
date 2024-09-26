import { Header } from './Header';
import Skill from './Skill';
import Hobbies from './Hobbies';

interface IUserList{
    data:{
      "name":string;
    "fullName": string;
    "qualification":string;
    skills: { id: number; skill: string }[];
    hobbies: { id: number; hobby: string }[];
    }
  }
  
const Profile = ({data}:IUserList) => {
    return (
        <>
        <Header name={data.name} fullName={data.fullName} qualification={data.qualification} />
          <Skill skills={data.skills} />
          <Hobbies hobbies={data.hobbies} />
        </>
        
      );
    }

export default Profile