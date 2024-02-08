class shoe{
    constructor(type, color, size, price){
        this.type = type;
        this.color = color;
        this.size=size;
        this.price = price;
    }
}
class shirt{
    constructor(type, color, size, price){
        this.type = type;
        this.color = color;
        this.size=size;
        this.price = price;
    }
}
const shoeArray = new Array(2);
const shirtArray = new Array(3);

shoeArray[0] = new shoe("Mens", "blue","45","150");
shoeArray[1] = new shoe("Womens", "White","46","78");

shirtArray[0]=new shirt("Regular","blue","S","9.99");
shirtArray[1]=new shirt("Medium","Black", "M","14.99");
shirtArray[2]=new shirt("Large","Red","L","19.99");

function displayItem(item) {
    console.log(`Type: ${item.type}`);
    console.log(`Color: ${item.color}`);
    console.log(`Size: ${item.size}`);
    console.log(`Price: ${item.price}\n`);
}

displayItem(shoeArray[0]);
const warehouse = new Array(6);
let i;
for(i=0;i<shirtArray.length;i++){
    warehouse[i]=shirtArray[i];
}
for(let j=0;j<shoeArray.length;j++) {
    warehouse[j+i]=shoeArray[j];
}
console.log(warehouse[4]);


let totalPrice=0;
warehouse.forEach ((value)=>{
    totalPrice=totalPrice + parseInt(value.price);

});
console.log(`Total Price of all items in the Warehouse is ${totalPrice}`)


console.log("Blue elements:")
warehouse.forEach ((value)=>{
    if(value.color == "blue"){
        console.log(value)
    }

});

warehouse1 = warehouse.sort(function(a,b)
{
    return b.price - a.price;
});
console.log("Warehouse elements in sorted order with the highest price first");
console.log(warehouse1[0]);
