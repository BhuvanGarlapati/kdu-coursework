// import { ProductInfo } from "../ProductInfo";
// import { createAsyncThunk } from "@reduxjs/toolkit";


//  const getProduct = createAsyncThunk('getProduct', async () => {
//     try {
//       const response = await fetch('https://fakestoreapi.com/products');
//       const data: ProductInfo[] = await response.json();
//       return data;
//     } catch (error) {
//       console.error('Error fetching product data:', error);
//       throw error; 
//     }
//   });
//   export default getProduct;


import { createAsyncThunk } from "@reduxjs/toolkit";

// import { DispatchType, RootState } from "redux/store";

export const getProducts = createAsyncThunk("getProducts", async()=>{
 
   const response = await fetch("https://fakestoreapi.com/products");
   const data = await response.json();
   return data;
});