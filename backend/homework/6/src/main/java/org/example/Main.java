package org.example;

import org.example.beans.Vehicle;
import org.example.beans.VehicleService;
import org.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.util.List;

public class Main {
    private static final LoggingSystem ls = new LoggingSystem();
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        VehicleService vehicleService = context.getBean(VehicleService.class);
        ls.logInfo("Generated vehicles:");
        List<Vehicle> vehicles = vehicleService.getVehicles();
        for (Vehicle vehicle : vehicles) {
            ls.logInfo(vehicle.toString());
        }

        ls.logInfo("\nMost expensive vehicle:");
        ls.logInfo(vehicleService.toString());
        ls.logInfo(vehicleService.getMostExpensiveVehicle().toString());

    }
}