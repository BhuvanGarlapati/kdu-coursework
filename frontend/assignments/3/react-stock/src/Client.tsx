import React, { useEffect } from 'react';
import io from 'socket.io-client';

const StockDashboard: React.FC = () => {
  const socket = io("http://localhost:5001");

  useEffect(() => {
    socket.on("stock-details", (price) => updatePrice(price));
    return () => {
      socket.disconnect();
    };
  }, []);

  const updatePrice = (newPrice: number) => {
    let currPrice = priceValue.textContent as string;
    currPrice = currPrice.substring(0, currPrice.length - 2);
    console.log(currPrice);

    const newPriceChange = Math.round((newPrice - parseFloat(currPrice)) / parseFloat(currPrice) * 100 * 100) / 100;
    const newBar = document.createElement("div");
    newBar.style.height = `${newPrice}px`;
    newBar.classList.add("bar-graph");
    newPriceChange >= 0 ? newBar.classList.add("up") : newBar.classList.add("down");

    if (newPriceChange >= 0) {
      priceValue.classList.add("up");
      priceValue.classList.remove("down");
      priceValueChange.classList.add("up");
      priceValueChange.classList.remove("down");
      priceValue.innerHTML = newPrice + ` &#8593;`;
    } else {
      priceValue.innerHTML = newPrice + ` &#8595;`;
      priceValue.classList.add("down");
      priceValue.classList.remove("up");
      priceValueChange.classList.add("down");
      priceValueChange.classList.remove("up");
    }

    priceValueChange.textContent = newPriceChange + "%";
    barGraphContainer.appendChild(newBar);
  };

  const generateTransaction = (transactionClass: string, amount: number) => {
    const newTransaction = document.createElement("div");
    newTransaction.classList.add("transaction");

    const transactionInfo = document.createElement("div");
    transactionInfo.classList.add("transaction-info");

    const stockQuantity = document.createElement("h3");
    stockQuantity.textContent = `${amount} Stocks`;
    inputquantity.value = "";
    stockQuantity.classList.add("quantity");

    transactionInfo.appendChild(stockQuantity);

    const transactionType = document.createElement("div");
    transactionType.classList.add("transaction-type");

    const tradeType = document.createElement("h1");
    tradeType.textContent = transactionClass;
    tradeType.classList.add(transactionClass);

    transactionType.appendChild(tradeType);
    newTransaction.appendChild(transactionInfo);
    newTransaction.appendChild(transactionType);
    transactionList.appendChild(newTransaction);
  };

  const priceValue = document.querySelector(".value") as HTMLElement;
  const priceValueChange = document.querySelector(".value-change") as HTMLElement;
  const barGraphContainer = document.querySelector(".bar-graph-container") as HTMLElement;
  const inputquantity = document.querySelector(".quantity-input") as HTMLInputElement;
  const transactionList = document.querySelector(".right-main") as HTMLElement;

  const buyButton = document.querySelector(".buy-btn") as HTMLElement;
  const sellButton = document.querySelector(".sell-btn") as HTMLElement;

  buyButton.addEventListener("click", () => generateTransaction("Buy", parseFloat(inputquantity.value)));
  sellButton.addEventListener("click", () => generateTransaction("Sell", parseFloat(inputquantity.value)));

  return (
    <div>
      {/* Your React components here */}
    </div>
  );
};

export default StockDashboard;
