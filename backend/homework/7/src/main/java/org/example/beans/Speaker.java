package org.example.beans;

public class Speaker {
    public void setBrand(String brand) {
        this.brand = brand;
    }

    private String brand;

    public void setPrice(double price) {
        this.price = price;
    }

    private double price;

    public Speaker(String brand, double price) {
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