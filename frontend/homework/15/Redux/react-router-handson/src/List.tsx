
import './Main.scss';
import { useDispatch, useSelector } from "react-redux";
import { RootState } from "./redux/store";
import {deleted} from "./redux/TodoSlice"

 
const List = () => {
    // const {filteredTodos} = useContext(TodoMidContext);
    const searchTerm = useSelector((state: RootState) => state.todo.searchTerm);
    const todos = useSelector((state: RootState) => state.todo.todos);

    const reduxDispatch = useDispatch();
    const deleteHandler = (index:number) => {
      reduxDispatch(deleted(index));
    };

const filteredTodos = searchTerm
? todos.filter((todo:string) => todo.toLowerCase().includes(searchTerm.toLowerCase()))
: todos; 
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