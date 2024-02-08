const bills = [145, 45, 280]
function tipCalculator(bill){
    if(bill<50){
        return 0.2*bill;
    }
    else if(bill>-50 && bill<=200){
        return 0.15*bill;
    }else{
        return 0.1*bill;
    }
}


const tipsArray = new Array(3);
const paidAmount = new Array(3);

for(let i=0;i<3;i++){
    tipsArray[i]=tipCalculator(bills[i]);
    paidAmount[i] = bills[i]+tipsArray[i];
}

console.log(tipsArray);
console.log(paidAmount);