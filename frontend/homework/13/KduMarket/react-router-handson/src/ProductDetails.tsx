import React, { useContext } from "react"
import { MarketContext } from "./Market"
import {  Link, useParams } from "react-router-dom"
import './ProductsDetails.scss'


const productdetails:React.CSSProperties={
display: 'flex',
flexDirection: 'column',
alignItems: 'center',
}
const producttitlediv:React.CSSProperties={

fontWeight: '600',
letterSpacing: '3px',
    }
    const productdescription:React.CSSProperties={
    display: 'grid',
    gridTemplateColumns: '1fr 1fr',
    gridGap: '40px',
    padding: '40px',
    }
const prodimage:React.CSSProperties={
    height: '400px',
    alignSelf: 'center',
    display: 'flex',
    justifySelf: 'center'
        }
const proddetails:React.CSSProperties={
    color: 'black'
}
const prodtitle:React.CSSProperties={
    color: 'black',
    fontWeight: '600',
    fontSize: 'large',
    marginBottom: '0'
 }
const prodprice:React.CSSProperties={
    color: 'darkblue',
    fontWeight: '700',
    marginTop: '0'
}

const proddescription:React.CSSProperties={
    color: 'rgb(88, 88, 88)',
    marginTop: '0'
 }
const backtolistbutton : React.CSSProperties={
    color: '#4586e2',
    border: '#4586e2 solid',
    backgroundColor: 'lightgray',
            }
        
export function ProductDetails() {

    const {selectedProduct} = useContext(MarketContext)
    const { id} = useParams()

    const product = selectedProduct.filter((prod) => prod.id === parseInt(id!))[0];

    if(!product)
    {
        return <div>Product not found</div>
    }

  return (
    <div style={productdetails}>
        <div style={producttitlediv}>
            <h1>{product.title}</h1>
        </div>
        <div style={productdescription}>
            <img src={`${product.image}`} alt=""  style={prodimage}/>
            <div style={proddetails}>
                <p style={prodtitle}>Model: {product.title}</p>
                <p style={prodprice}>Price: ${product.price}</p>
                <h6>Product Description</h6>
                <p style={proddescription}>
                    {product.description}
                </p>
                <Link to="/" >
                        <button style={backtolistbutton}>
                            Back to Products
                        </button>
                    </Link>

            </div>
        </div>

    </div>
  )
}