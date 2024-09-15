import React from 'react'
import { ApiQuote } from './types/quotes.types'
import './Quote.scss';


interface QuoteProps{
    quote:ApiQuote;
    filterQuotes:string[];
    setFilterQuotes:(value: string[]) => any;
}
const Quotes = ({quote,filterQuotes,setFilterQuotes}:QuoteProps) => {
  return (

    <div className='quote-container'>
        <h1 className='quote'>{quote.content}</h1>
        <p className='quote-author'>~{quote.author}</p>
        <p className='quote-date'>{quote.dateAdded}</p>
   
    <div className='quote-tag'>
        {quote.tags.map((q)=>{
            return <span  className='quote-tag-single' onClick={()=>{setFilterQuotes([...filterQuotes,q])}} key={q}>{q}</span>
        })}
       </div>
    </div>

  );
}

export default Quotes