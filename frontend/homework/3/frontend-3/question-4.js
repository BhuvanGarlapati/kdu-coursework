let inputString = '{"firstName":"Alex","lastName":"Hunter","email":"alex@yahoo.com","age":24, "city":"london", "country":"england"}';

let jsonObject = JSON.parse(inputString);

for (let key in jsonObject) {
    if (key !== 'email' && typeof jsonObject[key] === 'string') {
        jsonObject[key] = jsonObject[key].toUpperCase();
    }
}

console.log(jsonObject);


delete jsonObject['email'];

let outputString = JSON.stringify(jsonObject);

console.log(outputString);