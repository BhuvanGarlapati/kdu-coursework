import "./Heder.scss"
import { Link } from "react-router-dom";
import { useState } from "react";
const headercontainer:React.CSSProperties = {
    fontFamily:"Poppins",
    width:"100%",
    backgroundColor:"#1871c2",
    height:"10%",
    color:"white",
    display:"flex",
    flexDirection:"row",
    justifyContent:"space-between"
}
const left:React.CSSProperties={
    display:"flex",
    width:"20%",
    flexDirection:"row",
    alignItems:"center",
    justifyContent:"space-around",
    fontSize:"1em"
}
const bottomHeader:React.CSSProperties= {
    fontFamily:"Poppins",
    display:"flex",
    flexDirection:"row",
    width:"15%",
    fontSize:"17px",
    justifyContent:"space-around"
}
const iconstock:React.CSSProperties={
    marginRight:"10px",
    marginLeft:"20px",
    fontSize:"36px",
    alignItems:"center"
}

const Header = () => {
    const [isActive, setIsActive] = useState(false);

 const handleClick = () => {
    setIsActive(!isActive);
 };
  return (
    <>
    <div className="headerContainer" style={headercontainer}>
        <div>

            <h1> <i style={iconstock} className="fi fi-ss-chart-histogram"></i>KDU Stock Market</h1>

        </div>
        <div style={left} >
            <h3><Link to="/summarizer" style={{ textDecoration: 'none' ,color:"white"}}>Summarizer</Link></h3>
            <h3><Link to="/portfolio" style={{ textDecoration: 'none' ,color:"white"}}>My Portfolio</Link></h3>
        </div>
    </div>
    <div style={bottomHeader}>
    
      <h4>
        <Link to="/" style={{ textDecoration: 'none', color: "black" }} >
          Explore
        </Link>
      </h4>
     
    <h4>
        <Link to="/watchlist" style={{ textDecoration: 'none', color: "black" }} onClick={handleClick}>
          My WatchList
        </Link>
      </h4>
      {isActive && <div className="active" style={{ borderBottom: '4px solid #1871c2' ,marginTop:"-15px"}}></div>}
    </div>        <div>
        </div>
    </>
  )
}

export default Header