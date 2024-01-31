package com.example.jdbc.controller;

import com.example.jdbc.dao.ShiftUserDAO;
import com.example.jdbc.dto.ShiftUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/shift-users")
public class ShiftUserController {

    @Autowired
    private ShiftUserDAO shiftUserService;

    @GetMapping("/{shiftUserId}")
    public ResponseEntity<ShiftUserDTO> getShiftUserById(@PathVariable UUID shiftUserId) {
        ShiftUserDTO shiftUserDTO = shiftUserService.getById(shiftUserId);
        return ResponseEntity.ok(shiftUserDTO);
    }

    @GetMapping("/tenant/{tenantId}")
    public List<ShiftUserDTO> getAllShiftTypesByTenant(@PathVariable UUID tenantId) {
        return shiftUserService.getAllByTenant(tenantId);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createShiftUser(@RequestBody ShiftUserDTO shiftUserDTO) {
        shiftUserService.save(shiftUserDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Shift user created successfully.");
    }

    @PutMapping("/update/{shiftUserId}")
    public ResponseEntity<String> updateShiftUser(@PathVariable UUID shiftUserId, @RequestBody ShiftUserDTO shiftUserDTO) {
        shiftUserService.update(shiftUserId, shiftUserDTO);
        return ResponseEntity.ok("Shift user updated successfully.");
    }

    @DeleteMapping("/delete/{shiftUserId}")
    public ResponseEntity<String> deleteShiftUser(@PathVariable UUID shiftUserId) {
        shiftUserService.delete(shiftUserId);
        return ResponseEntity.ok("Shift user deleted successfully.");
    }
}
