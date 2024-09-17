package org.example;


public class InvalidDataException extends RuntimeException{
    public InvalidDataException(String message) {
        super(message);
    }
    public InvalidDataException(Throwable cause) {
        super(cause);
    }
}