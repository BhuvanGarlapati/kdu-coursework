package org.example.beans;

public class Vehicle {
    public void setName(String name) {
        this.name = name;
    }
    private number=10000;
    private String name;

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    private Speaker speaker;

    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }

    private Tyre tyre;
    private double price;

    public Vehicle(String name, Speaker speaker, Tyre tyre) {
        this.name = name;
        this.speaker = speaker;
        this.tyre = tyre;
        this.price = tyre.getPrice() + speaker.getPrice() + constantPrice();
    }

    public String getName() {
        return name;
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public Tyre getTyre() {
        return tyre;
    }

    private double constantPrice() {
        return 1000.0;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
