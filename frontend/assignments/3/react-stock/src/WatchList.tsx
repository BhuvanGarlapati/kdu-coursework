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
const paging:React.CSSProperties={
    display:"flex",
    justifyContent:"center",
    alignContent:"center",
    alignItems:"center",
    marginTop:"5px",
    position:"absolute",
    bottom:"54px",
    left:"660px"
  }
const company:React.CSSProperties={
    marginLeft:"20px"
}
const Price:React.CSSProperties= {
    marginRight:"20px",
    display:"flex",
    flexDirection:"row"
}
const watchlist:React.CSSProperties={
    marginLeft:"40px",
    marginRight:"20px",
    
}
const pagecontainer:React.CSSProperties = {
    display:"flex",
    justifyContent:"coloum",
    flexDirection:"column"
}

const removeicon:React.CSSProperties={
    color:"red",
    fontSize:"20px",
    textDecoration:"none",
    listStyleType:"none"
  }
  const company1:React.CSSProperties={
    marginLeft:"60px"
  }
  const Price1:React.CSSProperties= {
    marginRight:"20px",
    display:"flex",
    flexDirection:"row",
    width:"28%",
    justifyContent:"space-between"
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
import React from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { RootState, AppDispatch } from './redux/store';
import { removeFromWishlist } from './redux/stockSlice';
import Pagination from '@mui/material/Pagination';
import Stack from '@mui/material/Stack';
import { useState } from 'react'

interface Stock {
    id: string;
    name: string;
    price: number;
   }
const WatchlistPage: React.FC = () => {
 const dispatch = useDispatch<AppDispatch>();
 const allwishlist = useSelector((state: RootState) => state.stocks.wishlist);

 const handleRemoveFromWishlist = (stock: Stock) => {
    dispatch(removeFromWishlist(stock));
 };
 const itemsPerPage = 10;
 const [currentPage, setCurrentPage] = useState(1);

 const indexOfLastStock = currentPage * itemsPerPage;
 const indexOfFirstStock = indexOfLastStock - itemsPerPage;
 const wishlist = allwishlist.slice(indexOfFirstStock, indexOfLastStock);
 const handlePageChange = (event: React.ChangeEvent<unknown>, newPage: number) => {
    setCurrentPage(newPage);
  };
 return (
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
    <div style={pagecontainer}>
      {wishlist.map((stock) => (
        
        <div style={stockdiv} key={stock.id}>
        <div style={company1}>
        <h3>{stock.id}</h3>
        </div>
        <div style={Price1}>
            <div>
            <h3>{stock.price}</h3>
            </div>
            <div style={watchlist1}>
          <i style={removeicon} className="fi fi-bs-cross-circle" 
            onClick={() => handleRemoveFromWishlist(stock)}></i>
        
        </div>
        </div>   
    </div>
      ))}
    </div>
    <Stack style={paging} spacing={2}>
          <Pagination
            count={Math.ceil(allwishlist.length / itemsPerPage)}
            page={currentPage}
            onChange={handlePageChange}
            color="primary"
          />
        </Stack>
    </div>
 );
};

export default WatchlistPage;
