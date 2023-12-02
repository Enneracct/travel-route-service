package kpi.fam.travelroute.Controllers;

import kpi.fam.travelroute.Services.GeoCodingService;
import kpi.fam.travelroute.Model.Waypoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GeoCodingController {
    private final GeoCodingService geoCodingService;

    @Autowired
    public GeoCodingController(GeoCodingService geoCodingService) {
        this.geoCodingService = geoCodingService;
    }

    @GetMapping("/geocode")
    public String getPoint(@RequestParam("origin") String origin,
                           @RequestParam("destination") String destination,
                           Model model){
        System.out.println("Received cities: " + origin + destination);

        String result1 = geoCodingService.geocodeCity(origin);
        String result2 = geoCodingService.geocodeCity(destination);

        Waypoint waypoint = new Waypoint(origin, result1, destination, result2);
        model.addAttribute("waypoint", waypoint);
        System.out.println(origin + result1 + destination + result2);
        return "showmap";
    }
}
