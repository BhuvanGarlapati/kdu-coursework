/* eslint-disable @typescript-eslint/no-explicit-any */
// // src/components/StocksList.tsx
const maincontainer:React.CSSProperties={
    fontFamily:"Poppins",
    margin:"auto",
    width:"70%",
    height:"37rem",
    border: "2.4px solid black",
    borderRadius:"20px",
    // display:"flex",
    // flexDirection:"row",
    overflow:"scroll"
}
const blocktitle:React.CSSProperties ={
    display:"flex",
    justifyContent:"space-between",
    flexDirection:"row",
    height:"3rem",
    borderBottom:"2px solid black",
    width:"100%",
    alignContent: "center",
    alignItems:"center",
    fontSize:"27px",
    
}

const company:React.CSSProperties={
    marginLeft:"20px"
}
const company1:React.CSSProperties={
  marginLeft:"60px"
}
const Price:React.CSSProperties= {
    marginRight:"20px",
    display:"flex",
    flexDirection:"row"
}
const Price1:React.CSSProperties= {
  marginRight:"20px",
  display:"flex",
  flexDirection:"row",
  width:"28%",
  justifyContent:"space-between"
}
const watchlist:React.CSSProperties={
    marginLeft:"40px",
    marginRight:"20px",
    
}
const watchlist1:React.CSSProperties={
  marginLeft:"40px",
  marginRight:"20px",
  width:"30%",
  alignItems:"center",
  alignContent:"center",
  paddingTop:"13px"
}
const stockdiv:React.CSSProperties={
  display:"flex",
  justifyContent:"space-between",
  flexDirection:"row",
  width:"100%",
  alignContent: "center",
  alignItems:"center",
  fontSize:"12px",
  borderBottom: "1px solid grey",
}
const paging:React.CSSProperties={
  display:"flex",
  justifyContent:"center",
  alignContent:"center",
  alignItems:"center",
  marginTop:"5px"
}
const addicon:React.CSSProperties={
  color:"#1871c2",
  fontSize:"20px",
  textDecoration:"none",
  listStyleType:"none"
}

const removeicon:React.CSSProperties={
  color:"#1871c2",
  fontSize:"20px",
  textDecoration:"none",
  listStyleType:"none"
}

import React, { useEffect } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { RootState, AppDispatch } from './redux/store'
import { setStocks} from './redux/stockSlice'
import Pagination from '@mui/material/Pagination';
import Stack from '@mui/material/Stack';
import { useState } from 'react'
import { Link } from 'react-router-dom'
import { addToWishlist, removeFromWishlist } from './redux/stockSlice';



interface Stock {
 id: string;
 name: string;
 price: number;
}

const StocksList: React.FC = () => {



 const dispatch = useDispatch<AppDispatch>();
 const allStocks = useSelector((state: RootState) => state.stocks.stocks);
 const wishlist = useSelector((state: RootState) => state.stocks.wishlist);

 const itemsPerPage = 10;
 const [currentPage, setCurrentPage] = useState(1);

 const indexOfLastStock = currentPage * itemsPerPage;
 const indexOfFirstStock = indexOfLastStock - itemsPerPage;
 const stocks = allStocks.slice(indexOfFirstStock, indexOfLastStock);

 useEffect(() => {
    const fetchStocks = async () => {
      try {
        const response = await fetch('https://dev-1gyvfva3nqtb0v4.api.raw-labs.com/mock/stocks');
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        const data = await response.json();
        // Map API data to the expected structure
        const mappedData: Stock[] = data.map((item: any) => ({
          id: item.stock_symbol, // Assuming stock_symbol can be used as a unique identifier
          name: item.stock_name,
          price: item.base_price,
        }));
        dispatch(setStocks(mappedData));
      } catch (error) {
        console.error('There was a problem with your fetch operation:', error);
      }
    };

    fetchStocks();
 }, [dispatch]);

 const handleAddToWishlist = (stock: Stock) => {
  dispatch(addToWishlist(stock));
};

const handleRemoveFromWishlist = (stock: Stock) => {
  dispatch(removeFromWishlist(stock));
};
 const handlePageChange = (event: React.ChangeEvent<unknown>, newPage: number) => {
  setCurrentPage(newPage);
};
 return (
  <>
  <div style={maincontainer}>
    <div style={blocktitle}>
        <div style={company}>
          Company
        </div>
        <div style={Price}>
          <div>
            BasePrice
          </div>
          <div style={watchlist}>
            Watchlist
          </div>
        </div>    
      </div>
  <div>
    
  {stocks.map((stock) => (
    
    <div style={stockdiv} key={stock.id}>
      <div style={company1}>
      <Link key={stock.id} to={`/stock/${stock.id}${stock.name}`} style={{ textDecoration: 'none',color:"black" }}>
      <h3>{stock.id}</h3>
             
      {/* <h3>{stock.id}</h3> */}
      </Link>
      </div>
      <div style={Price1}>
          <div>
          <h3>{stock.price}</h3>
          </div>
          <div style={watchlist1}>
          <Link to="/watchlist" style={{ textDecoration: 'none' }}>
          {wishlist.find(wishlistStock => wishlistStock.id === stock.id) ? (
            <i style={removeicon} 
            className="fi fi-ss-check-circle"             
            onClick={() => handleRemoveFromWishlist(stock)}></i>
            
          ) : (
            <i style={addicon}
          className="fi fi-br-add"
          onClick={() => handleAddToWishlist(stock)}
        ></i>
          )}
          </Link>
        
          </div>
        </div>   
    </div>
  ))}
  
  </div>
  <Stack style={paging} spacing={2}>
          <Pagination
            count={Math.ceil(allStocks.length / itemsPerPage)}
            page={currentPage}
            onChange={handlePageChange}
            color="primary"
          />
        </Stack>
</div>

  </>
  
 );
};

export default StocksList;