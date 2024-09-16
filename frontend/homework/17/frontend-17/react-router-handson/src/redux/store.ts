
import { configureStore } from '@reduxjs/toolkit';
import productReducer from './ProductSlice';
import snackbarReducer from './SnackBarSlice'


const store = configureStore({
  reducer: {
    products: productReducer,
    snacks: snackbarReducer,
  },
});

export default store;
export type RootState = ReturnType<typeof store.getState>
export type AppDispatch = typeof store.dispatch;
