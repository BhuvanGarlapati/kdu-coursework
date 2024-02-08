const days = ["Sunday   ","   Monday  ","  Tuesday","Wednesday  ","  Thursday   ","   Friday","Saturday "]

const trimmer = (str) => {
    return str.trim().substring(0,3).toUpperCase();
}

const afterTrimer = days.map(trimmer);
console.log(afterTrimer);

const correction = {
    "a": "4",
    "s": "5",
    "e": "3",
    "i": "1",
    "o": "0"
  };

const inputs = ["javascript is cool   ", "programming is fun", "    become a coder"]

const triming = (str) => {
    return str.trim().replace(/a|s|e|i|o/g ,matched => correction[matched]);
}

const afterTrimming = inputs.map(triming);
console.log(afterTrimming);