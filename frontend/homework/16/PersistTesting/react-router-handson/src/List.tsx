import { RootState } from "./redux/store";
import './Main.scss';
import { useDispatch, useSelector } from "react-redux";

import {deleted} from "./redux/TodoSlice";

const List = () => {
  

    const reduxDispatch = useDispatch();
    const deleteHandler = (index:number) => {
      reduxDispatch(deleted(index));
    };
    

     const selectFilteredTodos = (state: RootState) => {
      const { todos, searchTerm } = state.todo;
      return searchTerm
        ? todos.filter((todo) => todo.toLowerCase().includes(searchTerm.toLowerCase()))
        : todos;
    };
    const filteredTodos = useSelector(selectFilteredTodos);
  return (
    <div className="todo-container">
      <h2>Items</h2>
      <ul className="todo-list">
      {filteredTodos.length > 0 ? (
        filteredTodos.map((todo:string, index:number) => (
          <li key={index} className="todo-item">
            {todo} <button onClick={() => deleteHandler(index)}>X</button>
          </li>
        ))
      ) : (
        
        <p>No Match found</p>
      )}
    </ul>
    </div>
  )
}

export default List