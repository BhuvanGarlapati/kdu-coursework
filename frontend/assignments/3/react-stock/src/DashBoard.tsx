import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import { Provider } from "react-redux"
import Header from "./Header"
import StocksList from "./StocksList"
import { store } from "./redux/store";
import WatchlistPage from './WatchList';
import PortfolioPage from './PortfolioPage';
import Summarizer from './Summarizer';
import StockMainSection from './StockMainsection';
const DashBoard = () => {
  return (
    <>
   <Provider store={store}>
   <Router>
   <Header/>
      <Routes>
        
        <Route path="/" element={<StocksList />} />
        <Route path="/watchlist" element={<WatchlistPage />} />
        <Route path="/portfolio" element={<PortfolioPage />} />
        <Route path="/summarizer" element={<Summarizer/>} />
        <Route path="/stock/:id" element={<StockMainSection/>}/>
      </Routes>
    </Router>
   </Provider>
   
    </>
  )
}

export default DashBoard