import { configureStore } from '@reduxjs/toolkit';
import stocksReducer from './stockSlice';
// import { persistReducer } from 'redux-persist';
// import { combineReducers } from "@reduxjs/toolkit";
// import storage from 'redux-persist/lib/storage';
import portfolioReducer from './portfolioSlice';
import filterReducer from './filterSlice';
import companySlice from './companySlice';
import summarizerSlice from './summarizerSlice'
import { TransactionSummaryReducer } from "../Interfaces/ISummarizer";

// const persistConfig = {
//     key: 'root',
//     // version:1,
//     storage,
//   }
//  const reducer = combineReducers({
//     stocks: stocksReducer,
//     portfolio: portfolioReducer,
//     filter: filterReducer,
//   })
//   const persistedReducer = persistReducer(persistConfig,reducer)
// export const store = configureStore({
//     reducer: persistedReducer,
 
// });
export const store = configureStore({
 reducer: {
  stocks: stocksReducer,
  portfolio: portfolioReducer,
  filter: filterReducer,
  company: companySlice,
  summarizer:summarizerSlice,
  transactionSummaryReducer: TransactionSummaryReducer,
},
});

export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;
