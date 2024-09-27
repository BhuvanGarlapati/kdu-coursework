package com.example.jpa.repository;

import com.example.jpa.dto.ShiftUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

public interface ShiftUserRepository extends JpaRepository<ShiftUser, UUID> {

    List<ShiftUser> findByShift_TimeEnd(LocalTime timeEnd);
}