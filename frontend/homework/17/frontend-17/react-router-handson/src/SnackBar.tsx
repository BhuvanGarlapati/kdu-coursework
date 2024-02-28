// src/components/Snackbar.tsx
import React from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { clearMessages } from './redux/SnackBarSlice';
import { AppDispatch, RootState } from './redux/store';

const Snackbar: React.FC = () => {
  const dispatch:AppDispatch = useDispatch();
  const { successMessage, errorMessage } = useSelector((state: RootState) => state.snacks);

  const handleClose = () => {
    dispatch(clearMessages());
  };

  return (
    <div>
      {successMessage && (
        <div style={{display:"flex",margin:"auto", justifyContent:"center", backgroundColor: 'green', color: 'white', padding: '10px', textAlign: 'center' ,width:"24%"}}>
          {successMessage}
          <button style={{backgroundColor: 'green'}} onClick={handleClose}>X</button>
        </div>
      )}
      {errorMessage && (
        <div style={{margin:"auto", backgroundColor: 'brown', color: 'white', padding: '10px', textAlign: 'center',width:"24%" }}>
          {errorMessage}
          <button  style={{backgroundColor: 'brown'}} onClick={handleClose}>X</button>
        </div>
      )}
    </div>
  );
};

export default Snackbar;
