package com.halitmancar.couriertracker.controller;

import com.halitmancar.couriertracker.dto.CourierLocationLogDto;
import com.halitmancar.couriertracker.dto.TotalDistanceDto;
import com.halitmancar.couriertracker.service.abstracts.CourierLocationLogService;
import com.halitmancar.couriertracker.service.abstracts.TotalDistanceService;
import com.halitmancar.couriertracker.service.proxy.TotalDistanceProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courier")
public class CourierTrackerController {

    private TotalDistanceProxy totalDistanceService;
    private CourierLocationLogService courierLocationLogService;

    public CourierTrackerController(CourierLocationLogService courierLocationLogService,
                                    TotalDistanceProxy totalDistanceService) {
        this.totalDistanceService= totalDistanceService;
        this.courierLocationLogService = courierLocationLogService;
    }

    @GetMapping("/getTotalTravel")
    public Double getTotalTravelDistance(@RequestParam Integer courierID){
        return totalDistanceService.getTotalTravelDistance(courierID);
    }

    @GetMapping("/getAllTotalTravels")
    public List<TotalDistanceDto> getAllTotalTravelDistances(){
        return totalDistanceService.getAllTotalTravelDistances();
    }

    @GetMapping("/getLogsOfCourier")
    public List<CourierLocationLogDto> getLogsByCourierID(@RequestParam Integer courierID){
        return courierLocationLogService.getLogsByCourierID(courierID);
    }
}
