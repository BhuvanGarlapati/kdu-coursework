import { createAsyncThunk } from "@reduxjs/toolkit";
import { ITransactionSummary } from "./Interfaces/ISummarizer";

export const getTransactionSummaryThunk = createAsyncThunk<
    ITransactionSummary[]
>("getTransactionSummaryThunk", async () => {
    return fetch("https://kdu-automation.s3.ap-south-1.amazonaws.com/mini-project-apis/all-stocks-transactions.json").then(
        (response) => {
            if (!response.ok) {
                throw new Error("Network response was not ok");
            }
            return response.json();
        }
    );
});