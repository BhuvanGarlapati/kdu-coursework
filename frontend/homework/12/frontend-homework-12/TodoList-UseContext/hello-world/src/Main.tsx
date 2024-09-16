import React, { useContext } from 'react';
import List from './List';
import { TodoContext } from './TodoList';
import './Main.scss';


interface ITodoMidContext{
    handleDeleteTodo: (index: number) => void;
    filteredTodos:string[]
}


export const TodoMidContext = React.createContext<ITodoMidContext>({
    handleDeleteTodo: () => {},
    filteredTodos:[]
  });
  


interface TodoMidProviderProps {
    children: React.ReactNode;
  }

  export function TodoMidProvider({ children }:TodoMidProviderProps){
    const {todos,setTodos,searchTerm} = useContext(TodoContext);
    const handleDeleteTodo = (index: number) => {
        const updatedTodos = [...todos];
        updatedTodos.splice(index, 1);
        setTodos(updatedTodos);
      };

      const filteredTodos = searchTerm
      ? todos.filter((todo) => todo.toLowerCase().includes(searchTerm.toLowerCase()))
      : todos;  

    // const search =  (e:any) => {
    //         setSearchTerm(e.target.value)
    // };

return (
    <TodoMidContext.Provider value={{filteredTodos,handleDeleteTodo}} >
        {children}
        </TodoMidContext.Provider>
);
};


const Midsection = () => {
    const {newTodoText,setNewTodoText,todos,setTodos} = useContext(TodoContext);
  const handleAddTodo = () => {
    if (newTodoText.trim() !== '') {
      setTodos([...todos, newTodoText]);
      setNewTodoText('');
    }
  };

  return (
    <>
    <TodoMidProvider>
    <div className="Mid-section">
      <h2>Add Items</h2>
      <input
        id="Add-itembox"
        type="text"
        placeholder="Add new item"
        value={newTodoText}
        onChange={(e) => setNewTodoText(e.target.value)}
      />
      <button className="submitbtn" onClick={handleAddTodo}>
        Submit
      </button>
      <List />
    </div>

    </TodoMidProvider>
    
    </>
   
  );
}

export default Midsection;