package com.kdu.smartHome.controller;

import com.kdu.smartHome.dto.HouseUpdateDto;
import com.kdu.smartHome.dto.HouseUserDto;
import com.kdu.smartHome.entity.HouseEntity;
import com.kdu.smartHome.service.HouseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class HouseController {
    @Autowired
    private HouseService houseService;

    @PostMapping("/house/{houseId}/add-user")
    public ResponseEntity<?> addUserToHouse(@PathVariable String houseId, @RequestBody HouseUserDto userHouseDto) {
        HouseEntity updatedHouse = houseService.addUserToHouse(houseId, userHouseDto.getUsername());
        return ResponseEntity.ok().body("User added to house successfully");
    }

    @GetMapping("/house")
    public ResponseEntity<List<HouseEntity>> getHouses() throws JsonProcessingException {
        return new ResponseEntity<>(houseService.getAll(), HttpStatus.OK);
    }

    @PutMapping("/house")
    public ResponseEntity<?> updateHouseAddress(@RequestParam String houseId, @RequestBody HouseUpdateDto houseUpdateDto) {
        HouseEntity updatedHouse = houseService.updateHouseAddress(houseId, houseUpdateDto.getNewAddress());
        return ResponseEntity.ok().body("House address updated successfully");
    }

    @GetMapping("/house/{houseId}")
    public ResponseEntity<?> getHouseById(@PathVariable String houseId) {
        HouseEntity house = houseService.getHouseById(houseId);
        return ResponseEntity.ok().body(house);
    }
}
