
import List from './List';
import './Main.scss';
import { useDispatch, useSelector } from "react-redux";
import { RootState } from "./redux/store";
import {added,setNewTodoText} from "./redux/TodoSlice"

const Midsection = () => {
  const newTodoText = useSelector((state: RootState) => state.todo.newTodoText);
  const reduxDispatch = useDispatch();
  const addHandler = () => {
    reduxDispatch(added());
  };
  const changeHandler = (e: React.ChangeEvent<HTMLInputElement>) => {
     reduxDispatch(setNewTodoText(e.target.value))
  }
  return (
    <>
    <div className="Mid-section">
      <h2>Add Items</h2>
      <input
        id="Add-itembox"
        type="text"
        placeholder="Add new item"
        value={newTodoText}
        onChange={(e)=>{changeHandler(e)}}
      />
      <button className="submitbtn" onClick={()=>addHandler()}>
        Submit
      </button>
      <List />
    </div>
    </>
  );
}

export default Midsection;