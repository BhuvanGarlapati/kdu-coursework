package com.example.chaching.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Data Transfer Object (DTO) for request reverse geocoding .
 */
@AllArgsConstructor
@Data
public class ReverseGeoCodingRequestDto{
    private String latitude;
    private String longitude;
}