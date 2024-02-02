package com.example.jpa.controller;

import com.example.jpa.dto.ShiftType;
import com.example.jpa.service.ShiftTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/shifttypes")
public class ShiftTypeController {

    @Autowired
    private ShiftTypeService shiftTypeService;

    @PostMapping
    public ResponseEntity<ShiftType> saveShiftType(@RequestBody ShiftType shiftTypeDto) {
        ShiftType savedShiftTypeDto = shiftTypeService.saveShiftType(shiftTypeDto);
        return new ResponseEntity<>(savedShiftTypeDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ShiftType>> getAllShiftTypes() {
        List<ShiftType> shiftTypes = shiftTypeService.getAllShiftTypes();
        return new ResponseEntity<>(shiftTypes, HttpStatus.OK);
    }

    @GetMapping("/{shiftTypeId}")
    public ResponseEntity<ShiftType> getShiftTypeById(@PathVariable UUID shiftTypeId) {
        ShiftType shiftType = shiftTypeService.getShiftTypeById(shiftTypeId);
        if (shiftType != null) {
            return new ResponseEntity<>(shiftType, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{shiftTypeId}")
    public ResponseEntity<Void> deleteShiftType(@PathVariable UUID shiftTypeId) {
        boolean deleted = shiftTypeService.deleteShiftType(shiftTypeId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
