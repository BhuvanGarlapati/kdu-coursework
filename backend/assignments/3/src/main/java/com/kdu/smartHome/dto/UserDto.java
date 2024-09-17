package com.kdu.smartHome.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    private String username;
    private String password;
    private String role;
    private String name;
    private String firstName;
    private String lastName;
    private String email;
}