import React, { useEffect } from 'react';
import { useDispatch } from 'react-redux';
import { Transaction } from './Interfaces/Transaction';
import { useSelector } from 'react-redux';
import { RootState } from './redux/store';
import dayjs from 'dayjs';
import {toggleCompanyFilter} from './redux/filterSlice'
import DatePickerValue from './DatePicker';
import {setStatusFilter} from './redux/filterSlice'
import { setSearchInput,clearSearchInput } from './redux/filterSlice';
import { setTransactions, setLoading } from './redux/portfolioSlice' // Adjust the import path as necessary

import isSameOrAfter from 'dayjs/plugin/isSameOrAfter';
import isSameOrBefore from 'dayjs/plugin/isSameOrBefore';

dayjs.extend(isSameOrAfter);
dayjs.extend(isSameOrBefore);
const portfolioblock:React.CSSProperties={
    display:"flex",
    flexDirection:"row",
    
}
const transactionblock:React.CSSProperties={
    fontFamily:"Poppins",
    display:"flex",
    flexDirection:"row",
    width:"50rem",
    justifyContent:"space-between",
    marginLeft:"35rem",
}
const dates:React.CSSProperties={
    marginLeft:"35rem",
    borderBottom:"1px dotted black",
    color:"grey",
}
const filterblock:React.CSSProperties ={
    width:"28%",
    border: "1px solid black", 
    borderRadius:"30px",
    height:"30rem",
    position:"fixed",
    marginLeft:"90px",
    marginTop:"25px",
    backgroundColor:"#e9ecef"
}
const times:React.CSSProperties={
    display:"flex",
    flexDirection:"row",
    alignContent:"center",
    alignItems: "center",
}
const stockname:React.CSSProperties= {
    width:"26%"
}
const filterclear:React.CSSProperties={
    display:"flex",
    flexDirection:"row",
    justifyContent:"space-between",
    margin:"0.5rem",
    borderBottom:"1px solid #6f7072"
}
const filtertext:React.CSSProperties={
    fontFamily:"Poppins",
    fontSize:"20px",
    marginLeft:"8px"
}
const cleartext:React.CSSProperties={
    fontFamily:"Poppins",
    fontSize:"20px",
    color:"#1b72c2",
    marginRight:"8px"
}
const searchinput:React.CSSProperties={
    width:"80%",
    fontFamily:"poppins",
    height:"2rem",
    borderRadius:"5px",
    alignItems:"center",
    alignContent:"center",
    marginTop:"1rem",
    marginBottom:"1.3rem"
}
const searchbar:React.CSSProperties={
    display:"flex",
    justifyContent:"center",
    alignItems:"center",
    borderBottom:"1px solid #6f7072",
    alignContent:"center",
    textAlign:"center"
}
const passfail:React.CSSProperties={
    color:"#6f7072",
    fontFamily:"Poppins",
    paddingLeft:"1rem",
    marginTop:"0.6rem",
    paddingBottom:"0.6rem",
    borderBottom:"1px solid #6f7072 "

}
const companyfilter:React.CSSProperties={
    overflow:"scroll",
    display: "block", 
    height:"12rem",
    fontFamily:"Poppins",
    color:"#6f7072",
    paddingLeft:"1rem",
    paddingTop:"1rem"
}


// Group transactions by date function
const groupTransactionsByDate = (transactions:Transaction[]) => {
    interface GroupedTransactions {
        [key: string]: Transaction[];
       }
       const grouped: GroupedTransactions = {};
    
   
    transactions.forEach((transaction) => {
       const date = new Date(transaction.timestamp).toISOString().split('T')[0];
       
       if (!grouped[date]) {
         grouped[date] = [];
       }
       grouped[date].push(transaction);
    });
   
    return grouped;
   };
   interface TransactionsListProps {
    transactions: Transaction[];
   }
   const TransactionsList: React.FC<TransactionsListProps> = ({ transactions }) => {
    const { searchInput, statusFilter, stockNameFilter, startDate, endDate  } = useSelector((state: RootState) => state.filter);

    const filteredTransactions = transactions.filter((transaction) => {
        const containsSearchInput = transaction.stock_name.toLowerCase().includes(searchInput.toLowerCase());
        const matchesStatusFilter = !statusFilter || transaction.status.toLowerCase() === statusFilter.toLowerCase();
        const matchesStockNameFilter = stockNameFilter.length === 0 || stockNameFilter.includes(transaction.stock_name);

        const formattedTimestamp = dayjs(transaction.timestamp).format('YYYY-MM-DD');
        const matchesStartDate = !startDate || dayjs(formattedTimestamp).isSameOrAfter(dayjs(startDate), 'day');
        const matchesEndDate = !endDate || dayjs(formattedTimestamp).isSameOrBefore(dayjs(endDate), 'day');
        return (
            containsSearchInput &&
            matchesStatusFilter &&
            matchesStockNameFilter&&
            matchesStartDate &&
            matchesEndDate
        );
      });
      const groupedTransactions = groupTransactionsByDate(filteredTransactions);
    // 
    
    return (
        <div>
           {Object.entries(groupedTransactions).map(([date, transactions]) => (
             <div key={date}>
               <h2 style={dates}>{dayjs(date).format('D MMM YYYY')}</h2>
               {transactions.map((transaction) => {
                 // Determine the dot style for each transaction based on its status
                 const dotStyle = transaction.status === "Failed" ? {marginLeft:'10px', backgroundColor: "red", height: "10px", width: "10px", borderRadius: "50%" } : {marginLeft:'10px', backgroundColor: "green", height: "10px", width: "10px", borderRadius: "50%" };
                 const formattedTimestamp = dayjs(transaction.timestamp).format('h:mm a');
                 return (
                   <div style={transactionblock} key={transaction.stock_symbol}>
                     <h4 style={stockname}>{transaction.stock_name}</h4>
                     <h4 style={stockname}>{transaction.stock_symbol}</h4>
                     <p style={stockname}> {transaction.transaction_price.toFixed(2)}</p>
                     <div style={times}>
                     <p>{formattedTimestamp} </p>
                     <div style={dotStyle}></div>
                     </div>   
                    
                   </div>
                 );
               })}
             </div>
           ))}
        </div>
       );
   };

   const PortfolioPage: React.FC = () => {
    const dispatch = useDispatch();
 useEffect(() => {
    const fetchTransactions = async ()=> {
      dispatch(setLoading(true));
      try {
        const response = await fetch('https://kdu-automation.s3.ap-south-1.amazonaws.com/mini-project-apis/portfolio-transactions.json');
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        const data: Transaction[] = await response.json();
        dispatch(setTransactions(data));
        console.log(setTransactions);
      } catch (error) {
        console.error('There was a problem with your fetch operation:', error);
      } finally {
        dispatch(setLoading(false));
      }
    };
    fetchTransactions();
 }, [dispatch]);
 
 const transactions = useSelector((state: RootState) => state.portfolio.transactions);
 const companies = Array.from(new Set(transactions.map(t => t.stock_name)));
 
// 
 const filterState = useSelector((state: RootState) => state.filter);

 const handleSearchChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    dispatch(setSearchInput(event.target.value));
 };
 const handleClearSearch = () => {
    dispatch(clearSearchInput());
 };

 const handleStatusFilterChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    const value = event.target.value as "Failed" | "Passed";
    dispatch(setStatusFilter(value));
  };
  const handleCompanyFilterChange = (companyName: string) => {
    dispatch(toggleCompanyFilter(companyName));
  };
  
 // Render your component
 return (
    <>
      <div style={portfolioblock}>
        <div style={filterblock}>

        <div style={filterclear}>
            <div style={filtertext}>Filter</div> 
            <div style={cleartext} onClick={handleClearSearch}>Clear All</div>
        </div>

        <div style={searchbar}>
        <input style={searchinput} placeholder="Search For a Stock" value={filterState.searchInput}
          onChange={handleSearchChange}></input>
        </div>
        <DatePickerValue/>
        <div style={passfail}>
        <input type="checkbox"  value="Failed" onChange={handleStatusFilterChange}></input>
        <label> Passed</label><br></br>
        <input type="checkbox"  value="Passed" onChange={handleStatusFilterChange}></input>
        <label>Failed</label><br></br>
        </div>

        <div style={companyfilter}>
            {companies.map(comapny => (
                <div key={comapny}>
                    <input type="checkbox"
              checked={filterState.stockNameFilter.includes(comapny)}
              onChange={() => handleCompanyFilterChange(comapny)}></input>
                    <label>{comapny}</label><br></br>
                </div>
            ))}
        </div>

        </div>
        <TransactionsList transactions={transactions} />
      </div>
   </>
 );
};

export default PortfolioPage;
