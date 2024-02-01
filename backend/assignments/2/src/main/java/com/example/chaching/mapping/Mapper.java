package com.example.chaching.mapping;


import com.example.chaching.dto.GeoCodingResponseDto;
import com.example.chaching.dto.ReverseGeoCodingResponseDto;
import com.example.chaching.model.LocationModel;

/**
 * Class of mapper which mapper to DTO
 */
public class Mapper {

    private Mapper() {
    }

    public static GeoCodingResponseDto convertToForwardResponse(LocationModel location) {
        return new GeoCodingResponseDto(location.getLatitude(), location.getLongitude());
    }
    public static ReverseGeoCodingResponseDto convertToReverseResponse(LocationModel location) {
        return new ReverseGeoCodingResponseDto(location.getLabel());
    }

    public static Mapper createMapper() {
        return new Mapper();
    }
}