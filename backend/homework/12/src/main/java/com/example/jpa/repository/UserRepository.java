package com.example.jpa.repository;

import com.example.jpa.dto.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface UserRepository extends JpaRepository<Users, UUID> {
    Page<Users> findAll(Pageable pageable);
    @Modifying
    @Transactional
    @Query(value = "UPDATE user u SET u.username = :username, u.loggedIn = :loggedIn, u.timeZone = :timeZone WHERE u.id = :userId", nativeQuery = true)
    void updateUserDetails(
            @Param("userId") UUID userId,
            @Param("username") String username,
            @Param("loggedIn") short loggedIn,
            @Param("timeZone") String timeZone);
}
