package kpi.fam.travelroute.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Waypoint {
    private String origin;
    private String originLoc;
    private String destination;
    private String destinationLoc;
}

