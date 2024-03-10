package com.halitmancar.couriertracker.controller;

import com.halitmancar.couriertracker.dto.CourierLocationLogDto;
import com.halitmancar.couriertracker.dto.TotalDistanceDto;
import com.halitmancar.couriertracker.service.abstracts.CourierLocationLogService;
import com.halitmancar.couriertracker.service.proxy.TotalDistanceProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courier")
public class CourierLocationLogController {

    private CourierLocationLogService courierLocationLogService;

    public CourierLocationLogController(CourierLocationLogService courierLocationLogService) {
        this.courierLocationLogService = courierLocationLogService;
    }

    @GetMapping("/getLogs")
    public List<CourierLocationLogDto> getLogsByCourierID(@RequestParam Integer courierID){
        return courierLocationLogService.getLogsByCourierID(courierID);
    }
}
