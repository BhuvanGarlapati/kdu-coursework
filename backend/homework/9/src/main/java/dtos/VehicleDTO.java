package dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
/**
 * @Data will get all setter and getter
 * @AllArgsConstructor will produce all constructor with all type of parameter
 */
@AllArgsConstructor
@Data
public class VehicleDTO {
    String vehicleName;
    double vehiclePrice;
}
