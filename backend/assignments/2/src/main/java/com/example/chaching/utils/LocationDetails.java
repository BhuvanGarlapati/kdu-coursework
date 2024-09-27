package com.example.chaching.utils;

import com.example.chaching.model.LocationModel;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;

/**
 * This class provides a method to extract location details from a JSON response.
 */
@Slf4j
public class LocationDetails {

    /**
     * Extracts location details from the provided JSON response.
     *
     * @param response The JSON response containing location information.
     * @return A LocationEntity object representing the parsed location details.
     * @throws JSONException If there is an error parsing the JSON response.
     */
    public static LocationModel locationDetails(JsonNode response) throws JSONException {
        JsonNode results = response.get("data").get(0);
        double latitude = results.get("latitude").asDouble();
        double longitude = results.get("longitude").asDouble();
        String label = results.get("label").asText();
        String postalCode = results.get("postal_code").asText();
        String region = results.get("region").asText();
        int number = results.get("number").asInt();
        log.info("Successfully parsed response");
        log.info("Latitude: " + latitude + " Longitude: " + longitude);
        return new LocationModel(label, latitude, longitude, postalCode, region, number);
    }
}