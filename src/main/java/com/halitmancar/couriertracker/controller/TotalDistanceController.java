package com.halitmancar.couriertracker.controller;

import com.halitmancar.couriertracker.dto.TotalDistanceDto;
import com.halitmancar.couriertracker.service.proxy.TotalDistanceProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/total-distance")
public class TotalDistanceController {

    private TotalDistanceProxy totalDistanceService;

    public TotalDistanceController(TotalDistanceProxy totalDistanceService) {
        this.totalDistanceService = totalDistanceService;
    }

    @GetMapping("/getTotalTravelDistance")
    public Double getTotalTravelDistance(@RequestParam Integer courierID){
        return totalDistanceService.getTotalTravelDistance(courierID);
    }

    @GetMapping("/getAllTotalTravels")
    public List<TotalDistanceDto> getAllTotalTravelDistances(){
        return totalDistanceService.getAllTotalTravelDistances();
    }
}
