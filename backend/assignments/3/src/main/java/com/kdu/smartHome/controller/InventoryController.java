package com.kdu.smartHome.controller;

import com.kdu.smartHome.dto.InventoryDto;
import com.kdu.smartHome.dto.InventoryResponseDto;
import com.kdu.smartHome.dto.SharedResponseDto;
import com.kdu.smartHome.service.InventoryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for handling inventory-related operations.
 */
@RestController
@RequestMapping("/api/v1")
public class InventoryController {

    @Autowired
    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping("/inventory")
    public ResponseEntity<SharedResponseDto> addItem(@RequestBody InventoryDto inventoryRequestDTO) {
        return new ResponseEntity<>(inventoryService.addItem(inventoryRequestDTO), HttpStatus.OK);
    }


    @GetMapping("/inventory")
    public ResponseEntity<InventoryResponseDto> getItem() throws JsonProcessingException {
        return new ResponseEntity<>(inventoryService.getItems(), HttpStatus.OK);
    }
}