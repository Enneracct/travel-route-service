package kpi.fam.travelroute.controller;

import kpi.fam.travelroute.Services.GeoCodingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeoCodingController {
    private final GeoCodingService geoCodingService;

    public GeoCodingController(GeoCodingService geoCodingService) {
        this.geoCodingService = geoCodingService;
    }
    @GetMapping("/geocode")
    public String getPoint(@RequestParam("origin") String origin,
                           @RequestParam("destination") String destination){
        System.out.println("Received cities: " + origin + destination);

        String result1 = geoCodingService.geocodeCity(origin);
        String result2 = geoCodingService.geocodeCity(destination);

        return "Result for " + origin + ": " + result1 + "\nResult for " + destination + ": " + result2;
    }
}
