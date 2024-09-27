package org.example.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Component
public class TyreService {

    @Primary
    Tyre bridgestoneTyre() {
        return new Tyre("Bridgestone", 10000);
    }

    Tyre mrfTyre() {
        return new Tyre("MRF", 11000);
    }
}
