package com.example.beans;


public class TyreService {

    public Tyre generateTyre() {
        String brand = Math.random() > 0.5 ? "Bridgestone" : "MRF";
        double price = brand.equals("Bridgestone") ? 200 : 180;
        return new Tyre(brand, price);
    }
}
