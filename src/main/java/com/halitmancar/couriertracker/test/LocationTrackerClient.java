package com.halitmancar.couriertracker.test;

import com.halitmancar.couriertracker.dto.RequestType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "api-test-service", url = "http://localhost:8797")
public interface LocationTrackerClient {

    @PostMapping("/track")
    public void sendCourierLog(RequestType request);

}
