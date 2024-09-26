package com.example.beans;

public class SpeakerService {

    public Speaker generateSpeaker() {

        String brand = Math.random() > 0.5 ? "Sony" : "Bose";
        double price = brand.equals("Sony") ? 150 : 200;
        return new Speaker(brand, price);
    }
}
