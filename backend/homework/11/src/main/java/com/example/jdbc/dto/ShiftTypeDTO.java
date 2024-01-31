package com.example.jdbc.dto;

import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public class ShiftTypeDTO {
    private UUID id;
    private String uqName;
    private String description;
    private boolean active;
    private Instant createdAt;
    private Instant updatedAt;
    private String timeZone;
    private UUID tenantId;

}
