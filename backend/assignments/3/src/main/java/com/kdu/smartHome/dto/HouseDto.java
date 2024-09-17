package com.kdu.smartHome.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;


@Data
@AllArgsConstructor
public class HouseDto {
    private String address;

    @JsonProperty("house_name")
    private String houseName;
}