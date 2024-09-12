package com.example.jdbc.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ShiftUserDTO {
    private UUID id;
    private UUID shiftId;
    private UUID userId;
    private UUID tenantId;

}