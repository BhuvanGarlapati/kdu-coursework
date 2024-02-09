package com.kdu.smartHome.mapping;

import com.kdu.smartHome.dto.InventoryDto;
import com.kdu.smartHome.entity.InventoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class InventoryMapper {
    @Autowired
    PasswordEncoder passwordEncoder;


    public InventoryEntity inventoryMapping(InventoryDto inventoryRequestDTO){
        InventoryEntity inventory = new InventoryEntity();
        inventory.setKickstonId(inventoryRequestDTO.getKickstonId());
        inventory.setDeviceUsername(inventoryRequestDTO.getDeviceUsername());
        inventory.setDevicePassword(inventoryRequestDTO.getDevicePassword());
        inventory.setManufactureDateTime(inventoryRequestDTO.getManufactureDateTime());
        inventory.setManufactureFactoryPlace(inventoryRequestDTO.getManufactureFactoryPlace());

        return inventory;
    }
}
