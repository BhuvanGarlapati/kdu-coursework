package org.example.beans;

enum SpeakerBrand{
    SONY,BOSE;
}
class Speaker{
    public SpeakerBrand getBrand() {
        return brand;
    }

    public void setBrand(SpeakerBrand brand) {
        this.brand = brand;
    }

    private SpeakerBrand brand;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private double price;

    public Speaker(SpeakerBrand brand,double price){
        this.brand=brand;
        this.price=price;
    }
    @Override
    public String toString() {
        return "Speaker{" +
                "brand=" + brand +
                ", price=" + price +
                '}';
    }
}