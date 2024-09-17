package com.kdu.smartHome.exception;

import com.kdu.smartHome.dto.ErrorDto;
import lombok.Data;

@Data
public class NotFoundException extends RuntimeException {
    private final ErrorDto errorDTO;
    public NotFoundException(String message){
        super(message);
        this.errorDTO = new ErrorDto(message,404);
    }
}