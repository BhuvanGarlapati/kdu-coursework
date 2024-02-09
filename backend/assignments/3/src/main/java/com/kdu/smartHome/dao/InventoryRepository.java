package com.kdu.smartHome.dao;

import com.kdu.smartHome.dto.InventoryDto;
import com.kdu.smartHome.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity,Long> {

    @Query
    Optional<InventoryEntity> findByKickstonId(String kickstonId);
}