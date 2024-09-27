package org.example.beans;

import org.springframework.stereotype.Component;

@Component("Factory2")
public class FactoryService2 implements Factory {

    public double addTransportationCost() {
        return 50;
    }
}
