package com.kdu.smartHome.exception;

import com.kdu.smartHome.dto.ErrorDto;
import lombok.Data;

@Data
public class IncorrectUsernamePasswordException extends RuntimeException {
    private final ErrorDto errorDTO;
    public IncorrectUsernamePasswordException(String message){
        super(message);
        this.errorDTO = new ErrorDto(message,401);
    }
}