// stockSlice.ts
import { createSlice, PayloadAction } from '@reduxjs/toolkit';

interface StockState {
  price: number;
  valueChange: number;
  transactions: Transaction[];
}

interface Transaction {
  type: string;
  amount: number;
  time: string;
}

const initialState: StockState = {
  price: 142.32,
  valueChange: 3.0,
  transactions: [],
};

const companySlice = createSlice({
  name: 'company',
  initialState,
  reducers: {
    setPrice: (state, action: PayloadAction<number>) => {
      state.price = action.payload;
    },
    setValueChange: (state, action: PayloadAction<number>) => {
      state.valueChange = action.payload;
    },
    addTransaction: (state, action: PayloadAction<Transaction>) => {
      state.transactions.push(action.payload);
    },
  },
});

export const { setPrice, setValueChange, addTransaction } = companySlice.actions;
export default companySlice.reducer;
