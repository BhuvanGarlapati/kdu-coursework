package org.example.beans;

import org.springframework.stereotype.Component;

@Component
public class TyreService {

    private static final double BRIDGESTONE_PRICE = 500;
    private static final double MRF_PRICE = 300;

    public Tyre generateTyre() {
        if (Math.random() > 0.5) {
            return new Tyre(TyreBrand.BRIDGESTONE, BRIDGESTONE_PRICE);
        } else {
            return new Tyre(TyreBrand.MRF, MRF_PRICE);
        }
    }
}