import './Main.scss';
import { useDispatch,useSelector } from "react-redux";
import { RootState } from "./redux/store";
import {setSearchTerm} from "./redux/TodoSlice"

const Header = () => {
  const searchTerm = useSelector((state: RootState) => state.todo.searchTerm);
  const reduxDispatch = useDispatch();
  const searchHandler=(e:  React.ChangeEvent<HTMLInputElement>)  => {
    reduxDispatch(setSearchTerm(e.target.value))
  }
  return (
    <div  className ="header">
      <h2 data-testid="cypress-title">Item Lister</h2>
      <div>
      <input className="searchbox"
        type="text"
        placeholder="Search..."
        onChange={searchHandler}
        value={searchTerm}
      />  
      </div>
    </div>
  )
}

export default Header