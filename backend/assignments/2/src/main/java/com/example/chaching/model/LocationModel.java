package com.example.chaching.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Location entity contains labels, latitude, longitude, postalcode, region, number
 */
@AllArgsConstructor
@Data
public class LocationModel {
    private String label;
    private double latitude;
    private double longitude;
    private String postalCode;
    private String region;
    private int number;
}