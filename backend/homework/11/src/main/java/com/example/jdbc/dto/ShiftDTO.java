package com.example.jdbc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.management.ConstructorParameters;
import java.time.Instant;
import java.util.UUID;

@Data
public class ShiftDTO {
    private String id;
    private String shiftTypeId;
    private String name;
    private String dateStart;
    private String dateEnd;
    private String timeStart;
    private String timeEnd;
    private Instant createdAt;
    private Instant updatedAt;
    private String timeZone;
    private String tenantId;

    // Getters and setters
}