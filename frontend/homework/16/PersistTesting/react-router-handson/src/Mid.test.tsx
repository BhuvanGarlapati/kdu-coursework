import {render,screen} from "@testing-library/react";
import { Provider } from 'react-redux';
import { store } from "./redux/store";

import Midsection from "./Midsection";

it("Add List",()=>{
    render(
        <Provider store={store}>
    <Midsection/>
    </Provider>);
    const message = screen.queryByText(/Add Items/i);
    expect(message).toBeVisible()
});

it("Add List",()=>{
    render(
        <Provider store={store}>
    <Midsection/>
    </Provider>);
    const submitButton = screen.getByText('Submit');
    expect(submitButton).toBeVisible()
});