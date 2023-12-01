package kpi.fam.travelroute.Services;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class GeoCodingService {
    private static final String apiUrl = "https://api.mapbox.com/geocoding/v5/mapbox.places/";
    private final ObjectMapper objectMapper;

    public GeoCodingService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
    public String geocodeCity(String city) {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = String.format("%s%s.json?&access_token=%s",GeoCodingService.apiUrl, city, "pk.eyJ1IjoieGludGVlIiwiYSI6ImNscGZ0c285azFnZjEyaW5rYngzNDRpbzAifQ.GeGzGfZnrXLKFqiXdy0DLg");
        String jsonResult = restTemplate.getForObject(apiUrl, String.class);

        try {
            JsonNode rootNode = objectMapper.readTree(jsonResult);

            JsonNode coordinatesNode = rootNode
                    .path("features")
                    .path(0)
                    .path("geometry")
                    .path("coordinates");

            double longitude = coordinatesNode.get(0).asDouble();
            double latitude = coordinatesNode.get(1).asDouble();

            return String.format(latitude + "," + longitude);

        } catch (IOException e) {
            e.printStackTrace();
            return "Error parsing JSON";
        }
    }
}
