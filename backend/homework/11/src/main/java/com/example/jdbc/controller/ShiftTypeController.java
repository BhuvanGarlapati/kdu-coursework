package com.example.jdbc.controller;

import com.example.jdbc.dao.ShiftTypeDAO;
import com.example.jdbc.dto.ShiftTypeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/shift-types")
public class ShiftTypeController {

    @Autowired
    private ShiftTypeDAO shiftTypeService;

    @PostMapping
    public void createShiftType(@RequestBody ShiftTypeDTO shiftTypeDTO) {
        shiftTypeService.save(shiftTypeDTO);
    }

    @GetMapping("/{id}")
    public ShiftTypeDTO getShiftTypeById(@PathVariable UUID id) {
        return shiftTypeService.getById(id);
    }

    @GetMapping("/tenant/{tenantId}")
    public List<ShiftTypeDTO> getAllShiftTypesByTenant(@PathVariable UUID tenantId) {
        return shiftTypeService.getAllByTenant(tenantId);
    }

    @PutMapping("/{id}")
    public void updateShiftType(@PathVariable UUID id, @RequestBody ShiftTypeDTO shiftTypeDTO) {
        shiftTypeService.update(id, shiftTypeDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteShiftType(@PathVariable UUID id) {
        shiftTypeService.delete(id);
    }
}
