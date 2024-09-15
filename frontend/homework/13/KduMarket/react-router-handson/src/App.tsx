
import {BrowserRouter,Route,Routes} from "react-router-dom";
import { ProductDetails } from "./ProductDetails";

import Market from "./Market";



function App() {
  return (
    <BrowserRouter>
    <Routes>
          <Route path="/"  element={<Market/>} />
          <Route path="/product/:id" element={<ProductDetails/>} />
         

    </Routes>
    
    </BrowserRouter>
    

  )
}

export default App