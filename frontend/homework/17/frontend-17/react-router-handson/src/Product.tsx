import { useSelector } from "react-redux";
import { RootState } from "./redux/store";
import { ProductInfo } from "./ProductInfo";

export function Products(){
    const products= useSelector((state:RootState)=>state.products.products);
    const loadingState= useSelector((state:RootState)=>state.products.state);
    const productsError= useSelector((state:RootState)=>state.products.error);
    
    if(loadingState==="pending"){
        return<div>Loading.......</div>
    }
    if(loadingState==="error"){
        return <div>Error {productsError}</div>
    }
   

    return (
        <div>
          {products.map((product: ProductInfo) => (
            <div key={product.id}>
              <h3>{product.title}</h3>
              <p>Price: ${product.price}</p>
              <p>Description: {product.description}</p>
              <p>Category: {product.category}</p>
              {/* Add more details as needed */}
            </div>
          ))}
        </div>
      );


}