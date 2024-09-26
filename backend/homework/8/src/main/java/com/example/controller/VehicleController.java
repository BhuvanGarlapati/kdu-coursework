package com.example.controller;

import com.example.beans.Vehicle;
import com.example.beans.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/vehicles")
@Validated
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<String> addVehicle(@RequestBody Vehicle vehicle) {
        vehicleService.addVehicle(vehicle);
        return ResponseEntity.status(HttpStatus.CREATED).body("Vehicle added successfully");
    }

    @GetMapping("/{vehicleName}")
    public ResponseEntity<Vehicle> getVehicle(@PathVariable String vehicleName) {
        Vehicle vehicle = vehicleService.getVehicle(vehicleName);
        if (vehicle != null) {
            return ResponseEntity.ok(vehicle);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

        @PutMapping("/{vehicleName}")
        public ResponseEntity<String> updateVehicle(@PathVariable String vehicleName, @RequestBody Vehicle updatedVehicle) {
            if (vehicleService.updateVehicle(vehicleName, updatedVehicle)) {
                return ResponseEntity.ok("Vehicle updated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vehicle not found");
            }
        }
        @DeleteMapping("/{vehicleName}")
        public ResponseEntity<String> deleteVehicle(@PathVariable String vehicleName) {
            if (vehicleService.deleteVehicle(vehicleName)) {
                return ResponseEntity.ok("Vehicle deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vehicle not found");
            }
        }

    @GetMapping("/expensive")
    public ResponseEntity<Object> getMostExpensiveVehicle(@RequestParam(required = false, defaultValue = "false") boolean leastExpensive) {
        if (leastExpensive) {
            Vehicle leastExpensiveVehicle = vehicleService.getLeastExpensiveVehicle();
            if (leastExpensiveVehicle != null) {
                return ResponseEntity.ok(leastExpensiveVehicle);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No least expensive vehicle found");
            }
        } else {
            Vehicle mostExpensiveVehicle = vehicleService.getMostExpensiveVehicle();
            if (mostExpensiveVehicle != null) {
                return ResponseEntity.ok(mostExpensiveVehicle);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No expensive vehicle found");
            }
        }

    }

    @GetMapping("/filter")
    public ResponseEntity<Object> getVehiclesByFilter(
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) Double maxPrice) {
        List<Vehicle> filteredVehicles = vehicleService.getVehiclesByFilter(brand, maxPrice);
        if (!filteredVehicles.isEmpty()) {
            return ResponseEntity.ok(filteredVehicles);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No vehicles found for the given filter");
        }
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        List<Vehicle> allVehicles = vehicleService.getAllVehicles();
        return ResponseEntity.ok(allVehicles);
    }
}

