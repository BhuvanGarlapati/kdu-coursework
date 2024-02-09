package com.kdu.smartHome.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SharedResponseDto {
    private String message;
    private String info;
    private HttpStatus httpStatus;
}