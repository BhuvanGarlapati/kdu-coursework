package com.example.chaching.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Location not found custom runtime exception class
 */
@AllArgsConstructor
@Data
public class LocationNotFound extends RuntimeException {
    private final String message;
}