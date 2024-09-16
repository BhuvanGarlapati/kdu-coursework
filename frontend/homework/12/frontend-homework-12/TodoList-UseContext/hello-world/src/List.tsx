import React, { useContext } from 'react'
import './Main.scss';
import { TodoMidContext } from './Main';

const List = () => {
    const {handleDeleteTodo,filteredTodos} = useContext(TodoMidContext);
  return (
    <div className="todo-container">
      <h2>Items</h2>
      <ul className="todo-list">
      {filteredTodos.length > 0 ? (
        filteredTodos.map((todo, index) => (
          <li key={index} className="todo-item">
            {todo} <button onClick={() => handleDeleteTodo(index)}>X</button>
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