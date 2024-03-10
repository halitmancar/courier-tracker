package com.halitmancar.couriertracker.service.concrete;

import com.halitmancar.couriertracker.dto.TotalDistanceDto;
import com.halitmancar.couriertracker.mapping.ModelMapperManager;
import com.halitmancar.couriertracker.model.CourierLocationLog;
import com.halitmancar.couriertracker.model.TotalDistance;
import com.halitmancar.couriertracker.repository.TotalDistanceRepository;
import com.halitmancar.couriertracker.service.abstracts.CourierService;
import com.halitmancar.couriertracker.service.abstracts.LocationTrackerService;
import com.halitmancar.couriertracker.service.abstracts.TotalDistanceService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("totalDistanceManager")
public class TotalDistanceManager implements TotalDistanceService {

    @Autowired
    private TotalDistanceRepository totalDistanceRepository;
    @Autowired
    @Lazy
    private LocationTrackerService locationTrackerService;

    @Override
    @Async
    public Double update(CourierLocationLog courierLocationLog) {
        TotalDistance totalDistance = totalDistanceRepository.findByCourier(courierLocationLog.getCourier());
        updateTotalDistance(totalDistance, courierLocationLog);
        totalDistanceRepository.save(totalDistance);
        return totalDistance.getTotalDistanceTravelled();
    }

    @Override
    public Double getTotalTravelDistance(Integer courierID){
        return totalDistanceRepository.findTotalDistancedByCourierId(courierID).getTotalDistanceTravelled();
    }

    @Override
    public List<TotalDistanceDto> getAllTotalTravelDistances() {
        List<TotalDistance> totalDistanceList = totalDistanceRepository.findAll();
        return totalDistanceList.stream().map(totalDistance -> ModelMapperManager.getMapper()
                .map(totalDistance, TotalDistanceDto.class)).collect(Collectors.toList());
    }

    private void updateTotalDistance(TotalDistance totalDistance, CourierLocationLog courierLocationLog){
        Double travelledFromLastLog = locationTrackerService.calculateDistance(
                totalDistance.getLastSeenLat(), totalDistance.getLastSeenLng(),
                courierLocationLog.getLat(), courierLocationLog.getLng());
        Double oldTotalTravelled = totalDistance.getTotalDistanceTravelled();
        totalDistance.setTotalDistanceTravelled(oldTotalTravelled+travelledFromLastLog);
        totalDistance.setLastSeenLat(courierLocationLog.getLat());
        totalDistance.setLastSeenLng(courierLocationLog.getLng());
    }
}
