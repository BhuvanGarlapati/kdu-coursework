package com.example.chaching.repository;
import com.example.chaching.exceptions.InvalidInput;
import com.example.chaching.exceptions.LocationNotFound;
import com.example.chaching.model.LocationModel;
import com.example.chaching.utils.LocationDetails;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

/**
 * Repository class for handling reverse geocoding operations using an external API.
 */
@Repository
public class ReverseLocationRepository {

    @Value("${api-key}")
    private String apiKey;

    private static final String urlReverseGeoCoding = "http://api.positionstack.com/v1/reverse";
    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * Retrieves the location label for a given latitude and longitude using reverse geocoding from an external API.
     *
     * @return LocationEntity representing the reverse geocoding response.
     */
    @Cacheable(cacheNames = "reverse-geocoding", key = "{#latitude,#longitude}")
    public LocationModel getAddressLabel(String latitude, String longitude) {
        if (checkCoordinates(latitude, longitude)) {
            String url = urlReverseGeoCoding + "?access_key=" + apiKey + "&query=" + latitude + "," + longitude;
            JsonNode response = restTemplate.getForObject(url, JsonNode.class);
            if (response == null) {
                throw new LocationNotFound("error in fetching location in reverse geocoding");
            }
            return convertResponseToLocation(response);
        } else {
            throw new InvalidInput("Invalid Coordinates ");
        }
    }

    /**
     * Converts the API response to a LocationEntity for reverse geocoding.
     *
     * @param response The JSON response
     * @return LocationEntity
     */
    public LocationModel convertResponseToLocation(JsonNode response) {
        try {
            if (response.get("message") != null) {
                throw new InvalidInput("invalid input provided");
            }
            return LocationDetails.locationDetails(response);
        } catch (Exception e) {
            throw new LocationNotFound("Error in fetching ,parsing Reverse Geocoding");
        }
    }


    public boolean checkCoordinates(String lat, String longs) {
        try {
            double latitude = Double.parseDouble(lat);
            double longitude = Double.parseDouble(longs);
            if ((latitude <= 90.0 && latitude >= -90.0) && (longitude <= 180.0 && longitude >= -180.0)) {
                return true;
            } else {
                throw new InvalidInput(" given invalid coordinates  ");
            }
        } catch (NumberFormatException e) {
            throw new InvalidInput("given invalid coordinates");
        }
    }
}