package com.example.chaching.controller;

import com.example.chaching.dto.GeoCodingResponseDto;
import com.example.chaching.dto.ReverseGeoCodingRequestDto;
import com.example.chaching.dto.ReverseGeoCodingResponseDto;
import com.example.chaching.service.ServiceLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {

    private ServiceLocation locationService;

    /**
     * Constructor for LocationController.
     *
     * @param locationService The LocationService to be injected.
     */
    @Autowired
    public LocationController(ServiceLocation locationService) {
        this.locationService = locationService;
    }

    /**
     * Retrieves latitude and longitude coordinates for a given address.
     *
     * @param address The address for which coordinates are to be retrieved.
     * @return ResponseEntity containing ResponseForwardGeocoding and HTTP status.
     */
    @GetMapping("/geocoding")
    public ResponseEntity<GeoCodingResponseDto> getCoordinates(@RequestParam String address) {
        GeoCodingResponseDto responseGeocodingDTO = locationService.getLatitudeLongitude(address);
        return new ResponseEntity<>(responseGeocodingDTO, HttpStatus.OK);
    }

    /**
     * Retrieves the address details for a given latitude and longitude.
     *
     * @param latitude  The latitude for reverse geocoding.
     * @param longitude The longitude for reverse geocoding.
     * @return ResponseEntity containing the address and HTTP status.
     */
    @GetMapping("/reverse-geocoding")
    public ResponseEntity<String> getAddress(@RequestParam String latitude, @RequestParam String longitude) {
        ReverseGeoCodingRequestDto requestReverseGeoCoding = new ReverseGeoCodingRequestDto(latitude, longitude);
        ReverseGeoCodingResponseDto responseReverseGeocodingDTO = locationService.getAddressDetails(requestReverseGeoCoding);
        return new ResponseEntity<>(responseReverseGeocodingDTO.getAddress(), HttpStatus.OK);
    }
}