import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import { RootState } from './store';
import { Welcome } from '../Interfaces/ISummarizer';

export const fetchStocks = createAsyncThunk(
    'stocks/fetchStocks',
    async () => {
       const response = await fetch('https://kdu-automation.s3.ap-south-1.amazonaws.com/mini-project-apis/all-stocks-transactions.json');
       if (!response.ok) {
         throw new Error('Failed to fetch stocks');
       }
       const data: Welcome[] = await response.json();
       return data;
    }
   );
   
   // Define the structure of the state in your Redux slice
   interface SummarizerState {
    stocks: Welcome[];
    status: 'idle' | 'loading' | 'succeeded';
    error: string | null;
   }
   
   // Define the initial state
   const initialState: SummarizerState = {
    stocks: [],
    status: 'idle',
    error: null,
   };
   
   // Create the slice
   export const summarizerSlice = createSlice({
    name: 'summarizer',
    initialState,
    reducers: {},
    extraReducers: (builder) => {
       builder
         .addCase(fetchStocks.pending, (state) => {
           state.status = 'loading';
         })
         .addCase(fetchStocks.fulfilled, (state, action) => {
           state.status = 'succeeded';
           state.stocks = action.payload;
         })
         .addCase(fetchStocks.rejected, (state) => {
           state.status = 'idle';
           state.error = "ERROR";
         });
    },
   });
   
   // Define selectors
   export const selectStocks = (state: RootState) => state.summarizer.stocks;
   export const selectStatus = (state: RootState) => state.summarizer.status
   export const selectError = (state: RootState) => state.summarizer.error;
   
 

   export default summarizerSlice.reducer;   