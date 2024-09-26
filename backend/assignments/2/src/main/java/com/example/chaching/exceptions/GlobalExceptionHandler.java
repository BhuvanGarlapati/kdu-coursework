package com.example.chaching.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler for location not found and invalid input
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = LocationNotFound.class)
    public ResponseEntity<String> handleCustomException(LocationNotFound e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(value = InvalidInput.class)
    public ResponseEntity<String> invalidInputExceptionHandling(InvalidInput e) {
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> genericException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
    }
}