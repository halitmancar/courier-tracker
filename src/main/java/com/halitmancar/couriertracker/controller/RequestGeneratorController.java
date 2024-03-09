package com.halitmancar.couriertracker.controller;

import com.halitmancar.couriertracker.test.RequestGeneratorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class RequestGeneratorController {

    private RequestGeneratorService requestGeneratorService;

    public RequestGeneratorController(RequestGeneratorService requestGeneratorService) {
        this.requestGeneratorService = requestGeneratorService;
    }

    @PostMapping("/start")
    public void startSendingRequests(){
        requestGeneratorService.setCourierFirstLocations();
        requestGeneratorService.startSendingRequests();
    }

    @PostMapping("/stop")
    public void stopSendingRequests(){
        requestGeneratorService.stopSendingRequests();
    }
}
