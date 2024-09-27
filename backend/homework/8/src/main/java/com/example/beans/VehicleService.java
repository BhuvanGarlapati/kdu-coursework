package com.example.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService {
    private static final Logger logger = LoggerFactory.getLogger(VehicleService.class);

    private List<Vehicle> vehicles = new ArrayList<>();


    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        logger.info("Vehicle added to inventory: {}", vehicle.getName());
    }

    public Vehicle getVehicle(String vehicleName) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getName().equals(vehicleName)) {
                return vehicle;
            }
        }
        return null;
    }

    public boolean updateVehicle(String vehicleName, Vehicle updatedVehicle) {
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getName().equals(vehicleName)) {
                vehicles.set(i, updatedVehicle);
                logger.info("Vehicle updated: {}", updatedVehicle.getName());
                return true;
            }
        }
        return false;
    }

    public boolean deleteVehicle(String vehicleName) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getName().equals(vehicleName)) {
                vehicles.remove(vehicle);
                logger.info("Vehicle deleted from inventory: {}", vehicleName);
                return true;
            }
        }
        return false;
    }

    public Vehicle getMostExpensiveVehicle() {
        if (vehicles.isEmpty()) {
            return null;
        }

        Vehicle mostExpensive = vehicles.get(0);

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPrice() > mostExpensive.getPrice()) {
                mostExpensive = vehicle;
            }
        }

        return mostExpensive;
    }
    public Vehicle getLeastExpensiveVehicle() {
        if (vehicles.isEmpty()) {
            return null;
        }

        Vehicle leastExpensive = vehicles.get(0);

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPrice() < leastExpensive.getPrice()) {
                leastExpensive = vehicle;
            }
        }

        return leastExpensive;
    }
    public List<Vehicle> getVehiclesByFilter(String brand, Double maxPrice) {
        List<Vehicle> filteredVehicles = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {
            boolean matchesBrand = brand == null ;
            boolean withinPriceRange = maxPrice == null || vehicle.getPrice() <= maxPrice;

            if (matchesBrand && withinPriceRange) {
                filteredVehicles.add(vehicle);
            }
        }

        return filteredVehicles;
    }

    public List<Vehicle> getAllVehicles() {
        return vehicles;
    }
}
