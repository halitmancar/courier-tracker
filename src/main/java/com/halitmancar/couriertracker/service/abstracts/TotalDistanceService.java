package com.halitmancar.couriertracker.service.abstracts;

import com.halitmancar.couriertracker.dto.TotalDistanceDto;
import com.halitmancar.couriertracker.model.CourierLocationLog;

import java.util.List;

public interface TotalDistanceService {
    Double update(CourierLocationLog courierLocationLog);
    Double getTotalTravelDistance(Integer courierID);
    List<TotalDistanceDto> getAllTotalTravelDistances();
}
