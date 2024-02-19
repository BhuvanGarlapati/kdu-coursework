import './Header.css';
interface IHeader{
        "name":string;
        "fullName": string;
        "qualification":string
}

export function Header({name,fullName,qualification}:IHeader) {
  return (
    <>
    <div className="header">
    <div className="header-part">{name}</div>
    <div className="header-part">{fullName}</div>
    <div className="header-part">{qualification}</div>
    </div>
    
    </>
  )
}

