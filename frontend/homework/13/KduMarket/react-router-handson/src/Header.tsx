import { MarketContext } from "./Market";
import { useContext } from "react";
import { ApiItems } from "./ApiItems";
import { useEffect } from "react";
import SingleProduct from "./SingleProduct";
const header:React.CSSProperties = {
    width:"100%",
    height:70,
    backgroundColor:"#022963",
    display:"flex",
    flexDirection:"row",
    justifyContent:"space-around",
    alignItems:"center",
    alignContent:"center",
    textAlign:"center",
    color:"white",
    fontSize:"17px",
    fontFamily:"Cochin"

}

const Header=() =>{
  const {selectedProduct,setSelectedProduct,searchQuery,setSearchQuery,filterBrand,setFilterBrand,sortOrder,setSortOrder} = useContext(MarketContext);

  const filteredProducts = selectedProduct
  .filter(product =>
    product.title.toLowerCase().includes(searchQuery.toLowerCase())
  )
  .filter(
    product => filterBrand === 'All' || product.category === filterBrand
  );

  const sortedProducts = [...filteredProducts].sort((a, b) => {
    return sortOrder === 'ASC' ? a.price - b.price : b.price - a.price;
  });
  useEffect(()=>{
    fetch("https://fakestoreapi.com/products")
    .then((response) => response.json())
    .then((data:ApiItems[])=>{
      setSelectedProduct(data);
    });
  }, [searchQuery,setSelectedProduct, filterBrand, sortOrder]);
  return (
   
    <div style={header}>
        <div>
            <input type="text" placeholder="Search"/>
            <input
        type="text"
        placeholder="Search products..."
        value={searchQuery}
        onChange={e => setSearchQuery(e.target.value)}
      />
      <select
        value={filterBrand}
        onChange={e => setFilterBrand(e.target.value)}
      ></select>
        </div>
        <div>
        <label >Filter: </label>
          <input type="text" id="username" placeholder="BRANDS" />
        </div>

        <div>
        <label >Sort: </label>
          <input type="text" id="username" placeholder="PRICE" />
        </div>

        <select
        value={sortOrder}
        onChange={e => setSortOrder(e.target.value)}
      >
        <option value="ASC">Ascending</option>
        <option value="DESC">Descending</option>
      </select>
      {sortedProducts.map(product => (
        <SingleProduct
          key={product.id}
          product={product}
          setSelectedProduct={setSelectedProduct}
          selectedProduct={selectedProduct}
        />
      ))}
      
    </div>
  )
}

export default Header