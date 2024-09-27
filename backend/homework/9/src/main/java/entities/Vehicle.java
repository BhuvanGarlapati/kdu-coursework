package entities;


import lombok.AllArgsConstructor;
import lombok.Data;
/**
 * @Data will get all setter and getter
 * @AllArgsConstructor will produce all constructor with all type of parameter
 */
@Data
@AllArgsConstructor
public class Vehicle {


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    double price;



}
