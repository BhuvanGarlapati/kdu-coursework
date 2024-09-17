package com.kdu.smartHome.controller;

import com.kdu.smartHome.entity.UserEntity;
import com.kdu.smartHome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserEntity user) {
        UserEntity registeredUser = userService.register(user);
        return ResponseEntity.ok().body("User registered successfully");
    }
    @GetMapping("/register")
    public ResponseEntity<String> login(){
        return new ResponseEntity<>("test login", HttpStatus.CREATED);
    }
}

