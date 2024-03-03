// portfolioSlice.ts
import { createSlice, PayloadAction } from '@reduxjs/toolkit';
import { Transaction } from '../Interfaces/Transaction' // Import the Transaction interface

interface PortfolioState {
 transactions: Transaction[];
 loading: boolean;
}

const initialState: PortfolioState = {
 transactions: [],
 loading: false,
};

const portfolioSlice = createSlice({
 name: 'portfolio',
 initialState,
 reducers: {
    setTransactions: (state, action: PayloadAction<Transaction[]>) => {
      state.transactions = action.payload;
      state.loading = false;
    },
    
    setLoading: (state, action: PayloadAction<boolean>) => {
      state.loading = action.payload;
    },
 },
});

export const { setTransactions, setLoading } = portfolioSlice.actions;

export default portfolioSlice.reducer;
