package services;

import dtos.VehicleDTO;
import entities.Vehicle;
import lombok.AllArgsConstructor;
import mapper.VehicleMapper;
import repository.VehicleRepository;

@AllArgsConstructor
public class VehicleService {
    public static int addVehicles(Vehicle vehicle){
        VehicleRepository.vehicles.add(vehicle);
        return VehicleRepository.vehicles.size()-1;
    }
    public static Vehicle getVehicles(int id){
        return VehicleRepository.vehicles.get(id);
    }
    public static void updateVehicles(int id, VehicleDTO vehicleDto){
        Vehicle vehicle = VehicleMapper.getVehicleObject(vehicleDto);
        VehicleRepository.vehicles.get(id).setName(vehicle.getName());
        VehicleRepository.vehicles.get(id).setPrice(vehicle.getPrice());
    }
    public static void deleteVehicles(int id){
        VehicleRepository.vehicles.remove(id);
    }
    public static VehicleDTO leastExpensive(){
        return VehicleMapper.getVehicleDtoObject(VehicleRepository.leastExpensive());
    }
    public static VehicleDTO mostExpensive(){
        return VehicleMapper.getVehicleDtoObject(VehicleRepository.mostExpensive());
    }
}