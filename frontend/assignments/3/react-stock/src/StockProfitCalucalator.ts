import {IProfitSummary,ITransactionSummary,} from "./Interfaces/ISummarizer";

self.onmessage = (event: MessageEvent) => {
const transactionSummary = sortTransactionsByDate(event.data);
self.postMessage(
    transactionSummary.map((transaction: ITransactionSummary) =>
        calculateMaxProfitForTransaction(transaction)
    )
);
};

function sortTransactionsByDate(
    transactions: ITransactionSummary[]
): ITransactionSummary[] {
return transactions.map((company) => ({
    ...company,
    data: company.data.sort(
        (a, b) => new Date(a.date).getTime() - new Date(b.date).getTime()
    ),
}));
}

function calculateMaxProfitForTransaction(
    transaction: ITransactionSummary
): IProfitSummary {
    let maxProfit = 0;
    let buyDay = "";
    let sellDay = "";
    let buyAmount = 0;
    let sellAmount = 0;

for (let startDay = 0; startDay < transaction.data.length; startDay++) {
for (
    let endDay = startDay;
    endDay < transaction.data.length;
    endDay++
) {
    for (
        let startIndex = 0;
        startIndex < transaction.data[startDay].prices.length;
        startIndex++
    ) {
        if (transaction.data[startDay].prices[startIndex] < 0) continue;
for (
    let endIndex = 0;
    endIndex < transaction.data[endDay].prices.length;
    endIndex++
) {
    for (let i = 0; i < 10; i++) {
        if (
            (startDay === endDay && startIndex >= endIndex) ||
            transaction.data[endDay].prices[endIndex] < 0
        )
            continue;
        const currProfit =
            transaction.data[endDay].prices[endIndex] -
            transaction.data[startDay].prices[startIndex];
        if (maxProfit < currProfit) {
            maxProfit = currProfit;
            buyAmount =
                transaction.data[startDay].prices[startIndex];
            sellAmount =
                transaction.data[endDay].prices[endIndex];
            buyDay = transaction.data[startDay].date;
            sellDay = transaction.data[endDay].date;
        }
    }
    }
}
}
}
return {company: transaction.company,symbol: transaction.symbol,maxProfit: maxProfit,buyDay: buyDay,sellDay: sellDay,buyAmount: buyAmount,sellAmount: sellAmount,};
}