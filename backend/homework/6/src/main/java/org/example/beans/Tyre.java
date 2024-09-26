package org.example.beans;

enum TyreBrand {
    BRIDGESTONE, MRF
}

class Tyre {

    private TyreBrand brand;
    private double price;

    public Tyre(TyreBrand brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    public TyreBrand getBrand() {
        return brand;
    }

    public void setBrand(TyreBrand brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Tyre{" +
                "brand=" + brand +
                ", price=" + price +
                '}';
    }
}
