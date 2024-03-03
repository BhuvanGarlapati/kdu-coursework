import React from 'react';
import { useEffect, useState } from 'react';
import { io } from 'socket.io-client';
import { useParams } from 'react-router-dom';
// import updatePrice from './Client'
import './StockStyle.scss'
// import generateTransaction from './Client'
const StockMainSection: React.FC = () => {
    const [inputQuantity, setInputQuantity] = useState<number>();
    const { id } = useParams<{ id: string }>();
    const [price, setPrice] = useState<number>(142.32); // Initial price state
    const [priceChange, setPriceChange] = useState<number>(0);
    const [barGraph, setBarGraph] = useState<JSX.Element[]>([]);
    const [transactionList, setTransactionList] = useState<JSX.Element[]>([]);
  const socket = io("http://localhost:5001");
    useEffect(() => {
        socket.on("zomato", (initialPrice) => setPrice(initialPrice));
        
        const interval = setInterval(() => {
          const newPrice = Math.floor((Math.random() * 500) + 1);
         
      updatePrice(newPrice);
          setPrice(newPrice);
          console.log("New price fetched: " + newPrice);
        }, 5000);
        return () => {
          clearInterval(interval);
        };
      }, [socket]);

      const updatePrice = (newPrice: number) => {
        if (typeof newPrice === 'number' && !isNaN(newPrice)) {
            // If valid, update the price and priceChange
            const currPrice = price;
            const newPriceChange = Math.round((newPrice - currPrice) / currPrice * 100 * 100) / 100;
            setPrice(newPrice);
            setPriceChange(newPriceChange);
        
            // Generate a new bar based on the updated price
            const newBar = (
              <div
                key={barGraph.length}
                style={{
                  height: `${newPrice}px`,
                  backgroundColor: newPriceChange >= 0 ? '#b2f2bb' : '#ffc9c9',
                }}
                className={`bar-graph ${newPriceChange >= 0 ? 'up' : 'down'}`}
              ></div>
            );
        
            // Update the barGraph state
            setBarGraph((prevBarGraph) => [...prevBarGraph, newBar]);
          }
        };
      const generateTransaction = (transactionClass: string, amount: number) => {
        const currentDate = new Date();
        const transactionDate = currentDate.toLocaleDateString();
        const transactionTime = currentDate.toLocaleTimeString();
        const newTransaction = (
          <div key={transactionList.length + 1} className="transaction">
            <div className="transaction-info">
              <h3 className="quantity">{`${amount} Stocks`}</h3>
              <p className="transaction-datetime">{`Date: ${transactionDate}, Time: ${transactionTime}`}</p>
            </div>
            <div className="transaction-type">
              <h1 className={transactionClass}>{transactionClass}</h1>
            </div>
          </div>
        );
    
        setTransactionList((prevTransactions) => [...prevTransactions, newTransaction]);
      };
      const sellButtonClickHandler = () => {
        if (typeof inputQuantity === 'number' && !isNaN(inputQuantity)) {
            generateTransaction('Sell', inputQuantity);
          }
        const newPrice = price;
        updatePrice(newPrice);
      };    
      const buyButtonClickHandler = () => {
        if (typeof inputQuantity === 'number' && !isNaN(inputQuantity)) {
            generateTransaction('Buy', inputQuantity);
          }
        const newPrice = price;
        updatePrice(newPrice);
      };  
      useEffect(() => {
        buyButtonClickHandler();
        sellButtonClickHandler();
      }, []);
    
  return (
    <>
     <section className="main-container">
            <div className="left-main">
                <div className="company-info">
                    <div className="logo-container">
                       <h2>{id.substring(0,3)}</h2>
                        <h2>{id.substring(3)}</h2>
                    </div>
                    <div className="price-container">
                        <h2 className="price-tag">Price:</h2>
                        <h2 className={`value ${priceChange >= 0 ? 'up' : 'down'}`}>
          {price} {priceChange >= 0 ? '↑' : '↓'}
        </h2>
        <h3 className={`value-change ${priceChange >= 0 ? 'up' : 'down'}`}>
          {priceChange}%
        </h3>
                    </div>
                    <input
          type="number"
          placeholder="Enter QTY"
          className="quantity-input"
          value={inputQuantity}
          onChange={(e) => setInputQuantity(parseFloat(e.target.value))}
        />
                    <div className="buy-btn" onClick={buyButtonClickHandler}><h2>Buy</h2></div>
                    <div className="sell-btn" onClick={sellButtonClickHandler}><h2>Sell</h2></div>
                </div>
                <div className="graph-container">
                    <div className="item"></div>
                    <div className="item"></div>
                    <div className="item"></div>
                    <div className="item"></div>
                    <div className="item"></div>
                    <div className="item"></div>
                    <div className="item"></div>
                    <div className="item"></div>
                    <div className="item"></div>
                    <div className="item"></div>
                    <div className="item"></div>
                    <div className="item"></div>
                    <div className="item"></div>
                    <div className="item"></div>
                    <div className="item"></div>
                    <div className="item"></div>
                    <div className="item"></div>
                    <div className="item"></div>
                    <div className="item"></div>
                    <div className="item"></div>
                    <div className="item"></div>
                    <div className="item"></div>
                    <div className="item"></div>
                    <div className="item"></div>
                    <div className="item"></div>


                    <div className="bar-graph-container">{barGraph}</div>
                </div>
            </div>
            <div className="right-main">
                <h1>History</h1>
                <div>{transactionList}</div>
                
            </div>
            
        </section>
        
    </>
   
  );
};

export default StockMainSection;
