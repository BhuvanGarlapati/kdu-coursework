package org.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class VehicleService {
    @Autowired
    private SpeakerService speakerService;
    @Autowired
    private TyreService tyreService;
    private List<Vehicle> vehicleList;

    @PostConstruct
    public void generateVehicles() {
        vehicleList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            vehicleList.add(new Vehicle(tyreService.generateTyre(), speakerService.generateSpeaker(),
                    Math.random() * 10000));
        }
    }

    public List<Vehicle> getVehicles() {
        return vehicleList;
    }

    public Vehicle getMostExpensiveVehicle() {
        return vehicleList.stream()
                .max(Comparator.comparing(Vehicle::getPrice))
                .orElseThrow(VehicleNotFoundException::new);
    }

    class VehicleNotFoundException extends RuntimeException {

        public VehicleNotFoundException() {
            super("No vehicles found in the list");
        }
    }
}