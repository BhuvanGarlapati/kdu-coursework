package com.kdu.smartHome.exception;
import com.kdu.smartHome.dto.ErrorDto;
import lombok.Data;

@Data
public class InvalidCredentialsException extends RuntimeException{
    private final ErrorDto errorDTO;
    public InvalidCredentialsException(String message){
        super(message);
        this.errorDTO = new ErrorDto(message,401);
    }
}