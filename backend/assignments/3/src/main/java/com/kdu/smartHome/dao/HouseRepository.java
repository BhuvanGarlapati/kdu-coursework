package com.kdu.smartHome.dao;

import com.kdu.smartHome.entity.HouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends JpaRepository<HouseEntity, Long> {
    // You can add custom queries or methods here if needed
}