package org.example.beans;

public class Tyre {
    public void setBrand(String brand) {
        this.brand = brand;
    }

    private String brand;

    public void setPrice(double price) {
        this.price = price;
    }

    private double price;

    public Tyre(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }
}