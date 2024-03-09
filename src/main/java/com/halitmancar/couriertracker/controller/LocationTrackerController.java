package com.halitmancar.couriertracker.controller;

import com.halitmancar.couriertracker.dto.RequestType;
import com.halitmancar.couriertracker.service.abstracts.LocationTrackerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/track")
public class LocationTrackerController {

    private LocationTrackerService locationTrackerService;

    public LocationTrackerController(LocationTrackerService locationTrackerService) {
        this.locationTrackerService = locationTrackerService;
    }

    @PostMapping
    public void track(@RequestBody RequestType request){
        locationTrackerService.checkAllZones(request);
    }

}
