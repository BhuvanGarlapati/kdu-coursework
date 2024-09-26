package mapper;

import dtos.VehicleDTO;
import entities.Vehicle;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class VehicleMapper {
    public static Vehicle getVehicleObject(VehicleDTO vehicleDto){
        return new Vehicle(vehicleDto.getVehicleName(), vehicleDto.getVehiclePrice());
    }
    public static VehicleDTO getVehicleDtoObject(Vehicle vehicle){
        return new VehicleDTO(vehicle.getName(), vehicle.getPrice());
    }
}