package com.example.chaching.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Data Transfer Object (DTO) for response  forward geocoding.
 */
@AllArgsConstructor
@Data
public class GeoCodingResponseDto {
    private double latitude;
    private double longitude;
}
