

import { useContext } from "react"
import { TodoContext } from "./TodoList"
import './Main.scss';


const Header = () => {
    const {searchTerm, setSearchTerm}=useContext(TodoContext);
  return (
    <div  className ="header">
      <h2>Item Lister</h2>
      <div>
      <input className="searchbox"
        type="text"
        placeholder="Search..."
        value={searchTerm}
        onChange={(e) => setSearchTerm(e.target.value)}
      />  
      </div>
    </div>
  )
}

export default Header