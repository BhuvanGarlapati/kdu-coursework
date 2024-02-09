package com.kdu.smartHome.dao;

import com.kdu.smartHome.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Long> {
    // You can add custom queries or methods here if needed
}