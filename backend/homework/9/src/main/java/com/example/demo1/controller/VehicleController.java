package com.example.demo1.controller;
import dtos.VehicleDTO;
import exceptions.IndexNotFound;
import mapper.VehicleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.VehicleService;

@RestController
public class VehicleController {
    private static final String INDEX_NOT_FOUND_MESSAGE = "Index Not Found at- %d";
    private final Logger logger = LoggerFactory.getLogger(VehicleController.class);
    @PostMapping("/vehicle")
    public ResponseEntity<String> addVehicle(@RequestBody VehicleDTO vehicleDto){
        int  id =  VehicleService.addVehicles(
                VehicleMapper.getVehicleObject(vehicleDto));
        logger.error("Successful Addition");
        logger.info("At index - ".concat(String.valueOf(id)));
        return ResponseEntity.ok("Vehicle Added successfully at index- ".concat(String.valueOf(id)));
    }
    @GetMapping("/vehicle/{id}")
    public VehicleDTO getVehicle(@PathVariable int id){
        VehicleDTO vehicleDto = null;
        try {
            vehicleDto = VehicleMapper.getVehicleDtoObject(
                    VehicleService.getVehicles(id));
            return vehicleDto;
        }catch (IndexOutOfBoundsException e){
            logger.debug("Index not found");
            throw new IndexNotFound(String.format(INDEX_NOT_FOUND_MESSAGE, id));
        }
    }
    /**
     * Prodution update mapping
     * @param id
     * @param vehicleDto
     * @return
     */
    @Profile("prod")
    @PutMapping("/vehicle/update/{id}")
    public ResponseEntity<String> updateVehicle(@PathVariable int id, @RequestBody VehicleDTO vehicleDto){
        try {
            VehicleService.updateVehicles(id, vehicleDto);
            return ResponseEntity.ok("Vehicle Updated successfully at- ".concat(String.valueOf(id)));
        }catch (IndexOutOfBoundsException e){
            logger.debug("Index not found at update");
            throw new IndexNotFound(String.format(INDEX_NOT_FOUND_MESSAGE, id));
        }
    }
    /**
     * production delete mapping
     * @param id
     * @return
     * Annotate your beans or configuration classes with @Profile and specify the profile name or expression.
     * For example, @Profile(“prod”) or @Profile(“!dev”).
     */
    @Profile("prod")
    @DeleteMapping("/vehicle/delete/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable int id) {
        try {
            VehicleService.deleteVehicles(id);
            return ResponseEntity.ok("Vehicle deleted successfully");
        }catch (IndexOutOfBoundsException e){
            logger.debug("Index not found at delete");
            throw new IndexNotFound(String.format(INDEX_NOT_FOUND_MESSAGE, id));
        }
    }
    /**
     * developer update mapping
     * @param id
     * @param vehicleDto
     * @return
     */
    @Profile("dev")
    @PutMapping("/vehicleUpdate/{id}")
    public ResponseEntity<String> updateVeDevhicle(@PathVariable int id, @RequestBody VehicleDTO vehicleDto){
        try {
            VehicleService.updateVehicles(id, vehicleDto);
            return ResponseEntity.ok("Vehicle Updated successfully at- ".concat(String.valueOf(id)));
        }catch (IndexOutOfBoundsException e){
            logger.error("Index not found at update");
            throw new IndexNotFound(String.format(INDEX_NOT_FOUND_MESSAGE, id));
        }
    }
    /**
     * Developer delete mapping
     * @param id
     * @return
     * Annotate your beans or configuration classes with @Profile and specify the profile name or expression.
     * For example, @Profile(“!prod”) or @Profile(“dev”).
     */
    @Profile("dev")
    @DeleteMapping("/vehicleDelete/{id}")
    public ResponseEntity<String> deleteDevVehicle(@PathVariable int id) {
        try {
            VehicleService.deleteVehicles(id);
            return ResponseEntity.ok("Vehicle deleted successfully");
        }catch (IndexOutOfBoundsException e){
            logger.error("Index not found at delete");
            throw new IndexNotFound(String.format(INDEX_NOT_FOUND_MESSAGE, id));
        }
    }
    @GetMapping("/vehicle/expensive")
    public VehicleDTO getExpensiveVehicle(){
        return VehicleService.mostExpensive();
    }
    @GetMapping("/vehicle/notExpensive")
    public VehicleDTO getLeastExpensiveVehicle(){
        return VehicleService.leastExpensive();
    }
}