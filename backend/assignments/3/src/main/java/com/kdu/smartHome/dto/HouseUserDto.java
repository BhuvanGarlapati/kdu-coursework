package com.kdu.smartHome.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseUserDto {
    private String username;
    private long houseId;

    // Getters and Setters
}
