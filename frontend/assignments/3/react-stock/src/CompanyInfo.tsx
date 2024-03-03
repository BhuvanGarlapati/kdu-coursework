// CompanyInfo.tsx
import React from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { RootState } from './redux/store';
import { setPrice, setValueChange } from './redux/companySlice';

const CompanyInfo: React.FC = () => {
  const dispatch = useDispatch();
  const { price, valueChange } = useSelector((state: RootState) => state.company);

  const handleInputChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    const newPrice = parseFloat(event.target.value);
    dispatch(setPrice(newPrice));
    dispatch(setValueChange((newPrice - price) / price * 100));
  };

  return (
    <div className="company-info">
      {/* ... Other components from your original code ... */}
      <input
        type="number"
        placeholder="Enter QTY"
        className="quantity-input"
        value={valueChange}
        onChange={handleInputChange}
      />
      {/* ... Other components from your original code ... */}
    </div>
  );
};

export default CompanyInfo;
