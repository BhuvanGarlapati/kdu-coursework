package com.kdu.smartHome.service;


import com.kdu.smartHome.dao.InventoryRepository;
import com.kdu.smartHome.dto.InventoryDto;
import com.kdu.smartHome.dto.InventoryResponseDto;
import com.kdu.smartHome.dto.SharedResponseDto;
import com.kdu.smartHome.entity.InventoryEntity;
import com.kdu.smartHome.mapping.InventoryMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing the inventory of items.
 */
@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;
    private final InventoryMapper mapper;
    private final ListToJSON listToJSON;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository, InventoryMapper mapper, ListToJSON listToJSON) {
        this.inventoryRepository = inventoryRepository;
        this.mapper = mapper;
        this.listToJSON = listToJSON;
    }

    /**
     * Adds an item to the inventory.
     *
     * @param inventoryRequestDTO The DTO containing inventory item details.
     * @return The response containing information about the added item.
     */
    public SharedResponseDto addItem(InventoryDto inventoryRequestDTO) {
        InventoryEntity inventory = mapper.inventoryMapping(inventoryRequestDTO);
        inventoryRepository.save(inventory);
        return new SharedResponseDto("Item added successfully!", "Kickston ID : " + inventory.getKickstonId(), HttpStatus.OK);
    }


    public InventoryResponseDto getItems() throws JsonProcessingException {
        List<InventoryEntity> inventories = inventoryRepository.findAll();
        String inventoryJSON = listToJSON.convertListToJSONString(inventories);
        return new InventoryResponseDto(inventoryJSON, HttpStatus.OK);
    }
}