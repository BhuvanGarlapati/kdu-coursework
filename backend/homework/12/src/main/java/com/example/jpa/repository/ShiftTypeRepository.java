package com.example.jpa.repository;

import com.example.jpa.dto.ShiftType;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ShiftTypeRepository extends JpaRepository<ShiftType, UUID> {

}
