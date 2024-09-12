import { ApiItems } from "./ApiItems";
import Header from "./Header";
import MainSection from "./MainSection";
import { useState } from "react";
import * as React from 'react';
const fullpage:React.CSSProperties={
    backgroundColor:"#e1e5eb"
  }
interface IMarket{
    selectedProduct:ApiItems[];
    setSelectedProduct:React.Dispatch<React.SetStateAction<ApiItems[]>>;
    searchQuery:string;
    setSearchQuery:React.Dispatch<React.SetStateAction<string>>;
    filterBrand:string;
    setFilterBrand:React.Dispatch<React.SetStateAction<string>>;
    sortOrder:string;
    setSortOrder:React.Dispatch<React.SetStateAction<string>>;
}
export const MarketContext = React.createContext<IMarket>({
    selectedProduct:[],
    setSelectedProduct:()=>{},
    searchQuery:'',
    setSearchQuery:()=>{},
    filterBrand:'All',
    setFilterBrand:()=>{},
    sortOrder:'',
    setSortOrder:()=>{}
});

interface MarketProviderProps {
    children: React.ReactNode;
  }

export function MarketProvider({ children }:MarketProviderProps){
    const [selectedProduct, setSelectedProduct] = useState<ApiItems[]>([]);
    const [searchQuery, setSearchQuery] = useState<string>('');
    const [filterBrand, setFilterBrand] = useState<string>('All');
    const [sortOrder, setSortOrder] = useState<string>('ASC');


return (
    <MarketContext.Provider value={{selectedProduct, setSelectedProduct,searchQuery,setSearchQuery,filterBrand,setFilterBrand,sortOrder,setSortOrder}} >
        {children}
        </MarketContext.Provider>
);
}


function Market() {
    
  return (
    <>
    <div style={fullpage}>
    {/* <div>App</div> */}
    <Header/>
    <MainSection />
    </div>
    </>
  )
}

export default Market