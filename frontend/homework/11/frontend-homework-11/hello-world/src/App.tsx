
import './App.scss';
import { useEffect, useState } from 'react';
import { ApiQuote } from './types/quotes.types';
import Quotes from './Quotes';

function App() {

const [quotes,setQuotes] = useState<ApiQuote[]>([]);
let [generate, setGenerate] = useState(true);
const [search,setSearch] = useState<string>("");
const [allquotes, setAllquotes] = useState<ApiQuote[]>([]);
const [filterQuotes,setFilterQuotes] = useState<string[]>([]);


useEffect(()=>{
  setQuotes((allquotes)=>{
    return allquotes.filter((quote)=> 
    quote.tags[0].includes(filterQuotes[0]))
  })

},[search, allquotes,filterQuotes]);


function getNewQuote()
    {
      setGenerate(!generate)
    } 


    useEffect(()=>{
      fetch("https://api.quotable.io/quotes/random")
      .then((response) => response.json())
      .then((data:ApiQuote[])=>{
        setQuotes([data[0],...quotes]);
    });
    },[generate]);

    const removeFilter = (filter: string) => {
      setFilterQuotes(filterQuotes.filter((f) => f !== filter));
    };
        
  useEffect(()=>{
    fetch("https://api.quotable.io/quotes/random?limit=3")
    .then((response) => response.json())
    .then((data:ApiQuote[])=>{
      setQuotes(data);
    });
  },[]);

  return (
    <>
 
    <button className='new-quote' onClick={getNewQuote}>New Quotes</button>
<h3 className="title">Filters</h3>
      <div className="filters">
        {filterQuotes.length > 0 &&
          filterQuotes.map((filter) => {
            return (
              <span key={filter} className="filter">
                {filter}{" "}
                <button
                  className="remove-btn"
                  onClick={() => removeFilter(filter)}
                >
                  X
                </button>
              </span>
            );
          })}
      </div>
      <div className='border-below'></div>

    {quotes.map((quote)=>{
      return <Quotes key = {quote._id} quote=
      {quote} filterQuotes={filterQuotes} setFilterQuotes={setFilterQuotes} />
    })}
    </>
  );
}

export default App;
