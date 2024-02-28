
import React from 'react';
import { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { AppDispatch, RootState } from './redux/store';
import { fetchProductDataThunk } from './redux/SnackBarSlice';
import './App.scss';

const Heading: React.FC = () => {
  const dispatch:AppDispatch= useDispatch();
  const { productDetails, loading, error } = useSelector((state: RootState) => state.snacks);

  useEffect(() => {
    dispatch(fetchProductDataThunk()); 
  }, [dispatch]);
  
  return (
    <div id="Heading">
      {loading && 
      <div className="loader"></div>}
        {error && <p>Error: {error}</p>}
      {productDetails && (
      <h1>
        <span>KDU</span> MARKETPLACE
      </h1>
      )}
    </div>
  );
};

export default Heading;
