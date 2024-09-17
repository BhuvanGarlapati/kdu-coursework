package com.kdu.smartHome.dao;

import com.kdu.smartHome.entity.DeviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<DeviceEntity, String> {
    // You can add custom queries or methods here if needed
}