package com.example.chaching.repository;
import com.example.chaching.exceptions.InvalidInput;
import com.example.chaching.exceptions.LocationNotFound;
import com.example.chaching.model.LocationModel;
import com.example.chaching.utils.LocationDetails;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

/**
 * Location Repository class for external API.
 */

@Repository
@Slf4j
public class LocationRepository {

    @Value("${api-key}")
    private String apiKey;

    private static final String urlGeoCoding = "http://api.positionstack.com/v1/forward?";
    private final RestTemplate callAPI = new RestTemplate();

    /**
     * Retrieves location coordinates for a given address from an external API.
     *
     * @return LocationEntity represent the location coordinates.
     */
    @Cacheable(cacheNames = "geocoding", key = "#address", unless = "#address.toLowerCase().contains('goa')")
    public LocationModel getCoordinates(String address) {
        String url = urlGeoCoding + "access_key=" + apiKey + "&query=" + address;
        JsonNode apiResponse = callAPI.getForObject(url, JsonNode.class);
        if (apiResponse == null) {
            throw new LocationNotFound("The API response is null. Could not fetch the location");
        }
        return convertResponseToLocation(apiResponse);
    }

    /**
     * Converts the API response to a LocationEntity.
     * @param response The JSON response from the external API.
     */
    public LocationModel convertResponseToLocation(JsonNode response) {
        try {
            if (response.get("message") != null) {
                throw new InvalidInput("Invalid input provided");
            }
            return LocationDetails.locationDetails(response);
        } catch (Exception e) {
            log.error("Error parsing API response: " + e.getMessage());
            throw new LocationNotFound("Error while parsing the location");
        }
    }
}