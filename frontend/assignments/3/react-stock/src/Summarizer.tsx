
import { useEffect, useMemo, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { AppDispatch,  RootState } from "./redux/store";
import { getTransactionSummaryThunk } from "./TranSummarizerSlice";
import { setProfitSummary } from "./Interfaces/ISummarizer";
import "./StockStyle.scss";


const SummarizerPage = () => {
    const [dataFetched, setDataFetched] = useState(false);

    const worker = useMemo(
        () => new Worker(new URL("./StockProfitCalucalator", import.meta.url)),
        []
    );

    const { transactionSummary, profitSummary } = useSelector(
        (state: RootState) => state.transactionSummaryReducer
    );

    const reduxDispatch: AppDispatch = useDispatch();

    useEffect(() => {
        reduxDispatch(getTransactionSummaryThunk()).then(() => {
            setDataFetched(true);
        });
    }, [reduxDispatch]);

    useEffect(() => {
        if (dataFetched) {
            startComputation();
        }
    }, [dataFetched, transactionSummary]);

    const startComputation = () => {
        worker.postMessage(transactionSummary);
        worker.onmessage = (event) => {
            reduxDispatch(setProfitSummary(event.data));
        };
    };

return (
<div>
  { (
      <div className='profit-container'>
          {profitSummary.map((transactoinProfit) => {
              return (
      <div
          className='profit-stock'
          key={transactoinProfit.company}
      >
  <div className='profit-stock-left'>
      <h1 className='profit-stock-tag'>
          {transactoinProfit.company}
      </h1>
      <h4>{`Profit margin: ${transactoinProfit.maxProfit}`}</h4>
  </div>
  <div className='profit-stock-right'>
      <h4>{`Buy $${transactoinProfit.buyAmount} on ${transactoinProfit.buyDay}`}</h4>
      <h4>{`Sell $${transactoinProfit.sellAmount} on ${transactoinProfit.sellDay}`}</h4>
  </div>
            </div>
        );
    })}
</div>
  )}
</div>
    );
};

export default SummarizerPage;