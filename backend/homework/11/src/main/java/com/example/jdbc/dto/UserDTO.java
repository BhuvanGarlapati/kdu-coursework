package com.example.jdbc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;


@Data
public class UserDTO {
    private UUID id;
    private String username;
    private int loggedIn;
    private String timeZone;
    private UUID tenantId;


}