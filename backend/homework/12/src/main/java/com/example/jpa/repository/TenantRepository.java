package com.example.jpa.repository;

import com.example.jpa.dto.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface TenantRepository extends JpaRepository<Tenant, UUID> {
    // Add custom queries if needed
}
