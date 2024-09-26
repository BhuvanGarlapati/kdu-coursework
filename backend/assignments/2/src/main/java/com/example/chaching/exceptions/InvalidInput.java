package com.example.chaching.exceptions;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Custom runtime exception class to represent invalid input provided.
 */
@AllArgsConstructor
@Data
public class InvalidInput extends RuntimeException {
    private final String message;
}