package com.halitmancar.couriertracker.service.proxy;

import com.halitmancar.couriertracker.dto.TotalDistanceDto;
import com.halitmancar.couriertracker.model.Courier;
import com.halitmancar.couriertracker.model.CourierLocationLog;
import com.halitmancar.couriertracker.service.abstracts.TotalDistanceService;
import com.halitmancar.couriertracker.service.concrete.TotalDistanceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@DependsOn("totalDistanceManager")
public class TotalDistanceProxy implements TotalDistanceService {

    @Autowired
    private TotalDistanceManager totalDistanceService;
    private Map<Integer, Double> courierTotalTravelDistanceMap = new HashMap<>();

    public TotalDistanceProxy() {
        this.totalDistanceService = new TotalDistanceManager();
    }

    @Override
    public Double update(CourierLocationLog courierLocationLog) {
      double totalDistance = totalDistanceService.update(courierLocationLog);
      courierTotalTravelDistanceMap.put(courierLocationLog.getCourier().getId(), totalDistance);
      return 0.0;
    }

    @Override
    public Double getTotalTravelDistance(Integer courierID) {
        if (courierTotalTravelDistanceMap.containsKey(courierID)){
            return courierTotalTravelDistanceMap.get(courierID);
        } else {
            Double totalTravelDistance = totalDistanceService.getTotalTravelDistance(courierID);
            courierTotalTravelDistanceMap.put(courierID, totalTravelDistance);
            return totalTravelDistance;

        }
    }

    @Override
    public List<TotalDistanceDto> getAllTotalTravelDistances() {
        return totalDistanceService.getAllTotalTravelDistances();
    }
}
