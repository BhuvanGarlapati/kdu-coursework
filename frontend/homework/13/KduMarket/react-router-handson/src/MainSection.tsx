import { useContext } from 'react';
import { ApiItems } from './ApiItems';
import { useEffect } from 'react';
import { MarketContext } from './Market';

const title:React.CSSProperties= {
  width:"100%",
  height:"100px",
  textAlign:"center",
  alignItems:"center",
  paddingTop:"47px",
  fontSize:"50px"
}

const container:React.CSSProperties={
  display:"grid",
    gridTemplateColumns:"repeat(4, 1fr)",
    gridTemplateRows:"repeat(5, 1fr)",
    textAlign:"center",
    justifyContent:"center",
    alignContent:"center",
    margin:"auto",
    marginLeft:"100px",
    marginRight:"90px"
}

const product:React.CSSProperties={
    width:"80%",
    height:"300px",
    margin:"auto",
    display:"flex",
    flexDirection:"column",
    justifyContent:"space-between",
    alignItems:"center",
    borderRadius:"20px",
    marginBottom:"30px",
    backgroundColor:"white"

}
const images:React.CSSProperties={
  paddingTop:"17px",
    width:"100%",
    height:"75%",
    
}
const MainSection = () => {
    const {selectedProduct,setSelectedProduct} = useContext(MarketContext);

    useEffect(()=>{
        fetch("https://fakestoreapi.com/products")
        .then((response) => response.json())
        .then((data:ApiItems[])=>{
          setSelectedProduct(data);
        });
      },[]);
  return (
    <>

    <div style={title}>KDU MARKET PLACE</div>
    <div style={container}>
    {selectedProduct.map((quote)=>{
        
        return  <div style={product} key = {quote.id}>  
        <img style={images} src={quote.image} alt="images" />
        <div>{quote.title} $ {quote.price} </div>
    </div>  
      })};
    </div>
    
    </>
   
  )
}

export default MainSection