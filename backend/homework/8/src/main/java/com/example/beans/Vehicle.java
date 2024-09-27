package com.example.beans;

public class Vehicle {
    private String name;
    private Speaker speaker;
    private Tyre tyre;
    private double price;


    public Vehicle(String name, Speaker speaker, Tyre tyre, double price) {
        this.name = name;
        this.speaker = speaker;
        this.tyre = tyre;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    public Tyre getTyre() {
        return tyre;
    }

    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
