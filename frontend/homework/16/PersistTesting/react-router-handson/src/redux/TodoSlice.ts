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
        added:(state,action:PayloadAction<string>)=>{
            state.todos.push(action.payload);
              
        },
        deleted: (state, action: PayloadAction<number>)=>{
            state.todos.splice(action.payload,1);
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