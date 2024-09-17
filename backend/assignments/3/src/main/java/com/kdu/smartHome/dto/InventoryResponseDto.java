package com.kdu.smartHome.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryResponseDto {
    private String inventory;
    private HttpStatus httpStatus;
}