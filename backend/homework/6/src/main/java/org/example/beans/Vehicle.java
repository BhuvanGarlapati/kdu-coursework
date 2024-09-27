package org.example.beans;

public class Vehicle{
    private Tyre tyres;

    public Speaker getSpeakers() {
        return speakers;
    }

    public void setSpeakers(Speaker speakers) {
        this.speakers = speakers;
    }

    private Speaker speakers;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private double price;

    public Tyre getTyres() {
        return tyres;
    }

    public void setTyres(Tyre tyres) {
        this.tyres = tyres;
    }

    public Vehicle(Tyre tyres, Speaker speakers, double price){
        this.tyres=tyres;
        this.speakers=speakers;
        this.price= tyres.getPrice() + speakers.getPrice() +price;
    }
    @Override
    public String toString() {
        return "Vehicle{" +
                "tyre=" + tyres +
                ", speaker=" + speakers +
                ", price=" + price +
                '}';
    }
}