package com.kdu.smartHome.exception;

import com.kdu.smartHome.dto.ErrorDto;
import lombok.Data;

@Data
public class EmptyListException extends RuntimeException {
    private final ErrorDto errorDTO;
    public EmptyListException(String message){
        super(message);
        errorDTO = new ErrorDto(message,404);
    }
}