import React from 'react';
import { Link } from 'react-router-dom';
import { ApiItems } from './ApiItems';

const productimage:React.CSSProperties={
  width: '100px',
  display: 'flex',
  justifySelf: 'center'
}


const prodtitle:React.CSSProperties={
  color: 'black',
  fontSize: '10px'

  }

const productstyle:React.CSSProperties={
  backgroundColor: 'white',
  borderRadius: '10px',
  padding: '10px',
  display: 'grid',
  height: '300px'
}

const prodprice:React.CSSProperties={
  color: 'darkblue'
      }

      
interface ISinglrProduct{
    product:ApiItems;
    selectedProduct:ApiItems[];
    setSelectedProduct:React.Dispatch<React.SetStateAction<ApiItems[]>>;
}


const SingleProduct = ({ product, selectedProduct,setSelectedProduct }:ISinglrProduct) => {
  return (
    <div style={productstyle}>
      <p style={productimage}>{product.image}</p>
      <h3 style={prodtitle}> {product.title}</h3>
      <p>{product.category}</p>
      <p style={prodprice}>${product.price}</p>
      <Link to={`/product/${product.id}`} onClick={() => setSelectedProduct([...selectedProduct,product])}>
        View Details
      </Link>
    </div>
  );
};
export default SingleProduct