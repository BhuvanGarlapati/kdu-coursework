import { PayloadAction, createSlice } from "@reduxjs/toolkit";

interface ITodoReducer{
    searchTerm:string;
    // setSearchTerm:React.Dispatch<React.SetStateAction<string>>;
    todos:string[];
    setTodos: React.Dispatch<React.SetStateAction<string[]>>;
    newTodoText:string;
    setNewTodoText:React.Dispatch<React.SetStateAction<string>>;
}

  export const initialState:ITodoReducer = {
    searchTerm:'',
    // setSearchTerm:() => {},
    todos:[],
    setTodos:() => {},
    newTodoText:'',
    setNewTodoText:() => {},
}
    
const todoSlice = createSlice({
    name:"todo",
    initialState,
    reducers:{
        
        setTodos:(state, action: PayloadAction<string[]>) => {
            state.todos = action.payload;
        },
        added:(state)=>{
            if (state.newTodoText.trim() !== '') {
                state.setTodos([...state.todos, state.newTodoText]);
                console.log(state.todos[0])
                state.setNewTodoText('');
              }
        },
        deleted: (state, action: PayloadAction<number>)=>{
            const updatedTodos = [...state.todos];
            updatedTodos.splice(action.payload, 1);
            state.setTodos(updatedTodos);
        },
        setNewTodoText: (state, action: PayloadAction<string>) => {
            state.newTodoText = action.payload;
          }, 
          setSearchTerm: (state, action: PayloadAction<string>) => {
            state.searchTerm = action.payload;
          }
    }
});

export const {added,deleted,setNewTodoText,setSearchTerm} = todoSlice.actions;
export default todoSlice.reducer;