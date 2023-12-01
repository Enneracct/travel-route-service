package kpi.fam.travelroute.controller;
import kpi.fam.travelroute.biz.model.Waypoint;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WaypointsFormController {

    @GetMapping("/make-route")
    public String waypointsFrom(Model model){
        model.addAttribute("waypoint", new Waypoint());
        return "make-route";
    }

    @PostMapping("/make-route")
    public String waypointSubmit(@ModelAttribute Waypoint waypoint, Model model) {
        model.addAttribute("waypoint", waypoint);
        return "make-route";
    }

}
