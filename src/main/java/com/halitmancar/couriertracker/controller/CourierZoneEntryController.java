package com.halitmancar.couriertracker.controller;

import com.halitmancar.couriertracker.dto.CourierZoneEntryDto;
import com.halitmancar.couriertracker.service.abstracts.CourierZoneEntryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/zone-entry")
public class CourierZoneEntryController {

    private CourierZoneEntryService courierZoneEntryService;

    public CourierZoneEntryController(CourierZoneEntryService courierZoneEntryService) {
        this.courierZoneEntryService = courierZoneEntryService;
    }

    @GetMapping
    public List<CourierZoneEntryDto> getZoneEntries(){
        return courierZoneEntryService.getZoneEntries();
    }
}
