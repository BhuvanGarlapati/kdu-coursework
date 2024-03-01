// stockSlice.ts
import { createSlice, PayloadAction } from '@reduxjs/toolkit';
import { IRooms } from '../Interfaces/IRooms';


interface RoomsState {
 rooms:IRooms[] ;
 
}

const initialState: RoomsState = {
 rooms: [],

};

const roomSlice = createSlice({
 name: 'rooms',
 initialState,
 reducers: {
    setRooms: (state, action: PayloadAction<IRooms[]>) => {
      state.rooms = action.payload;
    },
    
 },
});

export const { setRooms } = roomSlice.actions;

export default roomSlice.reducer;
