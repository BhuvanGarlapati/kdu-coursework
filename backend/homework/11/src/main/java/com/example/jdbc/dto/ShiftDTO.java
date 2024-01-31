package com.example.jdbc.dto;

import lombok.Data;
import java.time.Instant;


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

}