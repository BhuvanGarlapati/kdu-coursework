package com.example.chaching.service;

import com.example.chaching.dto.GeoCodingResponseDto;
import com.example.chaching.dto.ReverseGeoCodingRequestDto;
import com.example.chaching.dto.ReverseGeoCodingResponseDto;
import com.example.chaching.mapping.Mapper;
import com.example.chaching.model.LocationModel;
import com.example.chaching.repository.LocationRepository;
import com.example.chaching.repository.ReverseLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for handling location-related operations.
 */
@Service
public class ServiceLocation {

    private final LocationRepository locationRepository;
    private final ReverseLocationRepository reverseLocationRepository;

    @Autowired
    public ServiceLocation(LocationRepository locationRepository, ReverseLocationRepository reverseLocationRepository) {
        this.reverseLocationRepository = reverseLocationRepository;
        this.locationRepository = locationRepository;
    }

    /**
     * Retrieves latitude and longitude coordinates for a given address.
     *
     * @param address The address for which coordinates are to be retrieved.
     * @return ResponseForwardGeocoding representing the forward geocoding response.
     */
    public GeoCodingResponseDto getLatitudeLongitude(String address) {
        LocationModel current = locationRepository.getCoordinates(address);
        return Mapper.convertToForwardResponse(current);
    }

    /**
     * Retrieves address details for a given latitude and longitude.
     *
     * @param requestReverseGeoCodingDto The DTO containing latitude and longitude for reverse geocoding.
     * @return ReverseGeoCodingResponseDto representing the reverse geocoding response.
     */
    public ReverseGeoCodingResponseDto getAddressDetails(ReverseGeoCodingRequestDto requestReverseGeoCodingDto) {
        LocationModel current = reverseLocationRepository.getAddressLabel(requestReverseGeoCodingDto.getLatitude(), requestReverseGeoCodingDto.getLongitude());
        return Mapper.convertToReverseResponse(current);
    }
}