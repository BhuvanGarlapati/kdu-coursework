
import { useEffect, useState } from 'react';
import './App.scss';
import { useDispatch } from "react-redux";
import { ProductInfo } from './ProductInfo';
import { fetchProductDataThunk } from './redux/SnackBarSlice';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import ProductList from './ProductListComponent';
import HeaderComponent from './HeaderComponent';
import Heading from './HeadingComponent';
import Snackbar from './SnackBar';
import ProductDetailsViewComponent from './ProductDetailsViewComponent';

import { AppDispatch } from './redux/store';
import { Products } from './Product';


function App() {
  const dispatch:AppDispatch = useDispatch();
  const [allProductinfo] = useState<ProductInfo[]>([]);
  const [searchTerm, setSearchTerm] = useState<string>('');
  const [selectedBrand, setSelectedBrand] = useState<string>('All');
  const [sortOrder, setSortOrder] = useState<string>('asc');
  const [showProductList, setShowProductList] = useState<boolean>(true);

  useEffect(() => {
    dispatch(fetchProductDataThunk());
  }, [dispatch]);
  

  const handleSearchChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setSearchTerm(event.target.value);
  };

  const handleBrandChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
    setSelectedBrand(event.target.value);
  };

  const handleSortChange = () => {
    setSortOrder((prevOrder) => (prevOrder === 'asc' ? 'desc' : 'asc'));
  };

  const filteredProducts = allProductinfo.filter((product) => {
    const titleMatch = product.title.toLowerCase().includes(searchTerm.toLowerCase());
    const brandMatch = selectedBrand === 'All' || product.category.toLowerCase() === selectedBrand.toLowerCase();
    return titleMatch && brandMatch;
  });

  const sortedProducts = [...filteredProducts].sort((a, b) => {
    const priceA = a.price;
    const priceB = b.price;
    return sortOrder === 'asc' ? priceA - priceB : priceB - priceA;
  });

  return (
    <Router>
      <div id="main">
        <HeaderComponent
          searchTerm={searchTerm}
          handleSearchChange={handleSearchChange}
          selectedBrand={selectedBrand}
          handleBrandChange={handleBrandChange}
          sortOrder={sortOrder}
          handleSortChange={handleSortChange}
        />
        
        <Heading />
        <Products/>
        <Snackbar />

        {showProductList && <ProductList products={sortedProducts} />}

        {/* Route for product details */}
        <Routes>
          <Route
            path="/product/:id"
            element={<ProductDetailsViewComponent allProductinfo={allProductinfo} setShowProductList={setShowProductList} />}
          />
        </Routes>
      </div>
    </Router>
  );
}

export default App;










