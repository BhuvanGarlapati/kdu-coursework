// src/redux/productSlice.ts
import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import { AppDispatch } from './store';

interface ProductInfo {
    id: number;
    title: string;
    price: number;
    description: string;
    category: string;
    image: string;
    rating: {
        rate: number;
        count: number;
    };
}

interface ProductState {
  productDetails: ProductInfo[] | null;
  loading: boolean;
  error: string | null;
  successMessage: string | null;
  errorMessage: string | null;
}

const initialState: ProductState = {
  productDetails: null,
  loading: false,
  error: null,
  successMessage: null,
  errorMessage: null,
};
export const fetchProductDataThunk = createAsyncThunk(
    'products/fetchProductData',
    async () => {
      try {
        const response = await fetch('https://fakestoreapi.com/products');
        const data: ProductInfo[] = await response.json();
        // console.log(data);
        return data;
      } catch (error) {
        console.error('Error fetching product data:', error);
        throw error; 
      }
    }
  );
  
  export const clearMessages = () => (dispatch: AppDispatch) => {
    dispatch(SnackBarSlice.actions.clearSuccessMessage());
    dispatch(SnackBarSlice.actions.clearErrorMessage());
  };
const SnackBarSlice = createSlice({
  name: 'snacks',
  initialState,
  reducers: {
    clearSuccessMessage: (state) => {
      state.successMessage = null;
    },
    clearErrorMessage: (state) => {
      state.errorMessage = null;
    },
  },
  extraReducers: (builder) => {
    builder
      .addCase(fetchProductDataThunk.pending, (state) => {
        state.loading = true;
        state.error = null;
        state.successMessage = null;
        state.errorMessage = null;
      })
      .addCase(fetchProductDataThunk.fulfilled, (state, action) => {
        state.loading = false;
        state.productDetails = action.payload;
        state.successMessage = 'Product Fetched Successfully';
      })
      .addCase(fetchProductDataThunk.rejected, (state) => {
        state.loading = false;
        state.error = "Error";
        state.errorMessage = 'Failed to fetch the Products ';
      });
  },
});

export default SnackBarSlice.reducer;
