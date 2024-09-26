package com.example.jpa.service;

import com.example.jpa.dto.Tenant;
import com.example.jpa.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TenantService {

    @Autowired
    private TenantRepository tenantRepository;

    public Tenant saveTenant(Tenant tenant) {
        // Additional logic before saving if needed
        return tenantRepository.save(tenant);
    }

    public List<Tenant> getAllTenants() {
        return tenantRepository.findAll();
    }

    public Tenant getTenantById(UUID tenantId) {
        Optional<Tenant> optionalTenant = tenantRepository.findById(tenantId);
        return optionalTenant.orElse(null);
    }



    public boolean deleteTenant(UUID tenantId) {
        Optional<Tenant> optionalTenant = tenantRepository.findById(tenantId);

        if (optionalTenant.isPresent()) {
            tenantRepository.deleteById(tenantId);
            return true;
        } else {
            return false;
        }
    }

}
