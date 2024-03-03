// TransactionList.tsx
import React from 'react';
import { useSelector } from 'react-redux';
import { RootState } from './redux/store';

const TransactionList: React.FC = () => {
  const transactions = useSelector((state: RootState) => state.company.transactions);

  return (
    <div>
      <h1>History</h1>
      <div className="transaction-list">
        {transactions.map((transaction, index) => (
          <div key={index} className="transaction">
            {/* Display transaction details here */}
          </div>
        ))}
      </div>
    </div>
  );
};

export default TransactionList;
