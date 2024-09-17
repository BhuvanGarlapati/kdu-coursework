package com.kdu.smartHome.exception;

import com.kdu.smartHome.dto.ErrorDto;
import lombok.Data;

@Data
public class NotAuthorizedException extends RuntimeException {
    private final ErrorDto errorDTO;
    public NotAuthorizedException(String message){
        super(message);
        this.errorDTO = new ErrorDto(message,400);
    }

}