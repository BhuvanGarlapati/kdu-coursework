package org.example.beans;
import org.springframework.stereotype.Component;

@Component("Factory1")
public class FactoryService1 implements Factory{

    public double addTransportationCost() {
        return 0;
    }
}
