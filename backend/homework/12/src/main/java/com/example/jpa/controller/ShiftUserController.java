package com.example.jpa.controller;

import com.example.jpa.dto.ShiftUser;
import com.example.jpa.service.ShiftUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/shiftusers")
public class ShiftUserController {

    @Autowired
    private ShiftUserService shiftUserService;

    // Endpoint to save a shift user
    @PostMapping
    public ResponseEntity<ShiftUser> saveShiftUser(@RequestBody ShiftUser shiftUserDto) {
        ShiftUser savedShiftUserDto = shiftUserService.saveShiftUser(shiftUserDto);
        return new ResponseEntity<>(savedShiftUserDto, HttpStatus.CREATED);
    }

    // Endpoint to get all shift users
    @GetMapping
    public ResponseEntity<List<ShiftUser>> getAllShiftUsers() {
        List<ShiftUser> shiftUsers = shiftUserService.getAllShiftUsers();
        return new ResponseEntity<>(shiftUsers, HttpStatus.OK);
    }

    // Endpoint to get a shift user by ID
    @GetMapping("/{shiftUserId}")
    public ResponseEntity<ShiftUser> getShiftUserById(@PathVariable UUID shiftUserId) {
        ShiftUser shiftUser = shiftUserService.getShiftUserById(shiftUserId);
        if (shiftUser != null) {
            return new ResponseEntity<>(shiftUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{shiftUserId}")
    public ResponseEntity<Void> deleteShiftUser(@PathVariable UUID shiftUserId) {
        boolean deleted = shiftUserService.deleteShiftUser(shiftUserId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
