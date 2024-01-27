package org.example.beans;

import jakarta.annotation.PostConstruct;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

import java.util.List;

@Component
public class VehicleService {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(VehicleService.class);
    protected  List<Vehicle> inventory = new ArrayList<>();
    private Factory factory;
    private TyreService tyreService;
    private SpeakerService speakerService;

    public static final List<Vehicle> vehicles = new ArrayList<>();

    @Autowired
    public VehicleService(TyreService tyreService, SpeakerService speakerService) {
        this.tyreService = tyreService;
        this.speakerService = speakerService;
    }


    public void setFactory(@Qualifier("Factory1") Factory factory) {
        this.factory = factory;
    }

    @PostConstruct
    public void addVehicle() {
        vehicles.add(new Vehicle("vehicle1", speakerService.boseSpeaker(), tyreService.bridgestoneTyre()));
        vehicles.add(new Vehicle("vehicle2", speakerService.sonySpeaker(), tyreService.mrfTyre()));
    }

    public void updateCost(double additionalCost) {
        for (Vehicle vehicle : vehicles) {
            vehicle.setPrice(vehicle.getPrice() + additionalCost);
        }
    }

    public void printVehiclesDetails() {
        for (Vehicle vehicle : vehicles) {
            inventory.add(vehicle);
            printVehicleDetails(vehicle);
        }
    }

    public void printMostExpensiveVehicle() {
        double price = 0.0;
        Vehicle mostExpensiveVehicle = null;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPrice() > price) {
                price = vehicle.getPrice();
                mostExpensiveVehicle = vehicle;
            }
        }
        if (mostExpensiveVehicle == null) {
            logger.info("Not Found");
        } else {
            logger.info(" Expensive Details of Vehicle  : ");
            printVehicleDetails(mostExpensiveVehicle);
        }
    }

    public void printVehicleDetails(Vehicle vehicle) {
        logger.info("Name of vehicle: {}", vehicle.getName());
        logger.info("Price of vehicle: {}", vehicle.getPrice());
    }
}
