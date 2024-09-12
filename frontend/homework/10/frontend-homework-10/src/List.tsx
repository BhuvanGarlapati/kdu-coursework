import React from 'react'

interface ListProps {
    todos: string[];
    onDelete: (index: number) => void;
  }
function List(props:ListProps) {
  return (
    <div className="todo-container">
      <h2>Items</h2>
      <ul id="todo-list">
      {props.todos.length > 0 ? (
        props.todos.map((todo, index) => (
          <li key={index} className="todo-item">
            {todo} <button onClick={() => props.onDelete(index)}>X</button>
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