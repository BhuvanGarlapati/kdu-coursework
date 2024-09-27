package com.example.jpa.controller;

import com.example.jpa.dto.Tenant;
import com.example.jpa.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tenants")
public class TenantController {

    @Autowired
    private TenantService tenantService;


    @PostMapping
    public ResponseEntity<Tenant> saveTenant(@RequestBody Tenant tenantDto) {
        Tenant savedTenantDto = tenantService.saveTenant(tenantDto);
        return new ResponseEntity<>(savedTenantDto, HttpStatus.CREATED);
    }

    // Endpoint to get all tenants
    @GetMapping
    public ResponseEntity<List<Tenant>> getAllTenants() {
        List<Tenant> tenants = tenantService.getAllTenants();
        return new ResponseEntity<>(tenants, HttpStatus.OK);
    }

    @GetMapping("/{tenantId}")
    public ResponseEntity<Tenant> getTenantById(@PathVariable UUID tenantId) {
        Tenant tenant = tenantService.getTenantById(tenantId);
        if (tenant != null) {
            return new ResponseEntity<>(tenant, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{tenantId}")
    public ResponseEntity<Void> deleteTenant(@PathVariable UUID tenantId) {
        boolean deleted = tenantService.deleteTenant(tenantId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
