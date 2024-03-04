import {render,screen} from "@testing-library/react";
import { Provider } from 'react-redux';
import { store } from "./redux/store";
import Header from "./Header";

it("Item List",()=>{
    render(
        <Provider store={store}>
    <Header/>
    </Provider>);
    const message = screen.queryByText(/Item List/i);
    expect(message).toBeVisible()
});
it("Search List",()=>{
    render(
        <Provider store={store}>
    <Header/>
    </Provider>);
      const searchInput = screen.getByPlaceholderText('Search...');
      expect(searchInput).toBeInTheDocument();
});



