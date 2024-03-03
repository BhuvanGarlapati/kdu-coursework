// portfolioService.ts
import { store } from './store';
import { setTransactions, setLoading } from './portfolioSlice';
import { Transaction } from '../Interfaces/Transaction' // Import the Transaction interface

export const fetchTransactions = async () => {
 store.dispatch(setLoading(true));
 try {
    const response = await fetch('https://dev-1gyvfva3nqtb0v4.api.raw-labs.com/mock/portfolio-transactions');
    if (!response.ok) {
      throw new Error('Failed to fetch transactions');
    }
    const data: Transaction[] = await response.json(); // Use the Transaction interface here
    store.dispatch(setTransactions(data));
 } catch (error) {
    console.error('Error fetching transactions:', error);
 } finally {
    store.dispatch(setLoading(false));
 }
};
