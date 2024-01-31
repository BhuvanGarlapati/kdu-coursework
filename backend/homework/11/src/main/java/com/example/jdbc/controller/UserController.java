package com.example.jdbc.controller;

import com.example.jdbc.dao.UserDAO;
import com.example.jdbc.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserDAO userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable UUID userId) {
        UserDTO userDTO = userService.getById(userId);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping("/tenant/{tenantId}")
    public List<UserDTO> getAllShiftTypesByTenant(@PathVariable UUID tenantId) {
        return userService.getAllByTenant(tenantId);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO) {
        userService.save(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully.");
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable UUID userId, @RequestBody UserDTO userDTO) {
        userService.update(userId, userDTO);
        return ResponseEntity.ok("User updated successfully.");
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable UUID userId) {
        userService.delete(userId);
        return ResponseEntity.ok("User deleted successfully.");
    }
}
