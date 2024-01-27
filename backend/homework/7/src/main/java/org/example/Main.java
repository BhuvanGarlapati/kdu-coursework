package org.example;

import org.example.beans.*;

import org.example.config.ProjectConfig;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.example.beans.VehicleService.inventory;

public class Main {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(VehicleService.class);
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Factory factory1 = context.getBean("Factory1", Factory.class);
        VehicleService vehicleService1 = context.getBean(VehicleService.class);

        vehicleService1.setFactory(factory1);
        vehicleService1.updateCost(factory1.addTransportationCost());

        logger.info("Vehicles in Factory-1:");
        vehicleService1.printVehiclesDetails();
        logger.info("Most expensive vehicle in Factory-1:");
        vehicleService1.printMostExpensiveVehicle();


        Factory factory2 = context.getBean("Factory2", Factory.class);
        VehicleService vehicleService2 = context.getBean(VehicleService.class);

        vehicleService2.setFactory(factory2);
        vehicleService2.updateCost(factory2.addTransportationCost());

        logger.info("Vehicles in Factory-2:");
        vehicleService2.printVehiclesDetails();
        logger.info("Most expensive vehicle in Factory-2:");
        vehicleService2.printMostExpensiveVehicle();

        logger.info("Vehicles in inventory:");
        printInventory();
        context.close();
    }

    public static void printInventory() {
        for (Vehicle vehicle : inventory) {
            logger.info("Name of vehicle: {}", vehicle.getName());
            logger.info("Tyre of vehicle: {}", vehicle.getTyre().getBrand());
            logger.info("Speaker of vehicle: {}", vehicle.getSpeaker().getBrand());
            logger.info("Price of vehicle: {}", vehicle.getPrice());
        }
    }
}