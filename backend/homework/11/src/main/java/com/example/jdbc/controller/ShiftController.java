package com.example.jdbc.controller;

import com.example.jdbc.dao.ShiftDAO;
import com.example.jdbc.dto.ShiftDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/shifts")
public class ShiftController {

    @Autowired
    private ShiftDAO shiftService;

    @GetMapping("/{shiftId}")
    public ResponseEntity<ShiftDTO> getShiftById(@PathVariable UUID shiftId) {
        ShiftDTO shiftDTO = shiftService.getById(shiftId);
        return ResponseEntity.ok(shiftDTO);
    }

    @GetMapping("/tenant/{tenantId}")
    public List<ShiftDTO> getAllShiftTypesByTenant(@PathVariable UUID tenantId) {
        return shiftService.getAllByTenant(tenantId);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createShift(@RequestBody ShiftDTO shiftDTO) {
        shiftService.save(shiftDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Shift created successfully.");
    }

    @PutMapping("/update/{shiftId}")
    public ResponseEntity<String> updateShift(@PathVariable UUID shiftId, @RequestBody ShiftDTO shiftDTO) {
        shiftService.update(shiftId, shiftDTO);
        return ResponseEntity.ok("Shift updated successfully.");
    }

    @DeleteMapping("/delete/{shiftId}")
    public ResponseEntity<String> deleteShift(@PathVariable UUID shiftId) {
        shiftService.delete(shiftId);
        return ResponseEntity.ok("Shift deleted successfully.");
    }
}
