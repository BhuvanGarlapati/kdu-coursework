// filterSlice.ts
import { createSlice, PayloadAction } from '@reduxjs/toolkit';

interface FilterState {
 statusFilter: "Failed" | "Passed" | "";
 stockNameFilter: string[];
 startDate: Date | null;
 endDate: Date | null;
 selectedCompany: string | null; 
 searchInput: string;
 
}

const initialState: FilterState = {
 statusFilter: '',
 stockNameFilter: [],
 startDate: null,
 endDate: null,
 selectedCompany: null,
 searchInput: '',
 
};

export const filterSlice = createSlice({
 name: 'filter',
 initialState,
 reducers: {
    setStatusFilter: (state, action: PayloadAction<""|"Failed" | "Passed">) => {
        state.statusFilter = action.payload;
      },
    setStockNameFilter: (state, action: PayloadAction<string[]>) => {
      state.stockNameFilter = action.payload;
    },
    setStartDate: (state, action: PayloadAction<Date | null>) => {
        state.startDate = action.payload;
      },
      setEndDate: (state, action: PayloadAction<Date | null>) => {
        state.endDate = action.payload;
      },
     setSelectedCompany: (state, action: PayloadAction<string>) => {
      state.selectedCompany = action.payload;
    },
    clearAllFilters: (state) => {
      state.statusFilter = '';
      state.stockNameFilter = [];
      state.startDate = null;
      state.endDate = null;
      
    },
    setSearchInput: (state, action: PayloadAction<string>) => {
        state.searchInput = action.payload;
      },
      clearSearchInput: (state) => {
        state.searchInput = '';
      },
      toggleCompanyFilter: (state, action: PayloadAction<string>) => {
        const companyName = action.payload;
        const index = state.stockNameFilter.indexOf(companyName);
  
        if (index !== -1) {
          // Company is already in the filter, remove it
          state.stockNameFilter.splice(index, 1);
        } else {
          // Company is not in the filter, add it
          state.stockNameFilter.push(companyName);
        }
      },
    },
});

export const {toggleCompanyFilter,setSearchInput,clearSearchInput,setSelectedCompany,setStatusFilter, setStockNameFilter, setStartDate, setEndDate, clearAllFilters } = filterSlice.actions;

export default filterSlice.reducer;
