package com.halitmancar.couriertracker.service.concrete;

import com.halitmancar.couriertracker.dto.RequestType;
import com.halitmancar.couriertracker.model.Courier;
import com.halitmancar.couriertracker.model.CourierLocationLog;
import com.halitmancar.couriertracker.model.CourierZoneEntry;
import com.halitmancar.couriertracker.model.Store;
import com.halitmancar.couriertracker.service.abstracts.*;
import com.halitmancar.couriertracker.service.proxy.TotalDistanceProxy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class LocationTrackerManager implements LocationTrackerService {

    private final double EARTH_RADIUS = 6371;
    private final double LIMIT_RADIUS = 100;
    private List<Store> storeList = new ArrayList<>();
    private StoreService storeService;
    private CourierZoneEntryService courierZoneEntryService;
    private CourierService courierService;
    private CourierLocationLogService courierLocationLogService;
    private TotalDistanceProxy totalDistanceService;

    public LocationTrackerManager(StoreService storeService, CourierZoneEntryService courierZoneEntryService,
                                  CourierService courierService, CourierLocationLogService courierLocationLogService,
                                  TotalDistanceProxy totalDistanceService) {
        this.storeService = storeService;
        this.courierZoneEntryService = courierZoneEntryService;
        this.courierService = courierService;
        this.courierLocationLogService = courierLocationLogService;
        this.totalDistanceService = totalDistanceService;
    }

    @Override
    public boolean checkAllZones(RequestType request){
        logCourierLocation(request);
        setStoreList();
        Courier courier = this.courierService.findByCourierID(request.getCourierID()).get();
        for (Store store : storeList){
            boolean isWithinRadius = isWithinRadius(store.getLat(), store.getLng(), request.getLat(), request.getLng());
            if (isWithinRadius){
                CourierZoneEntry courierZoneEntry = CourierZoneEntry.builder()
                        .courier(courier)
                        .store(store)
                        .time(request.getTime())
                        .build();
                courierZoneEntry.setLat(request.getLat());
                courierZoneEntry.setLng(request.getLng());

                courierZoneEntryService.save(courierZoneEntry);
                log.info("Courier with name {} entered the zone of store {}",courier.getCourierName(), store.getStoreName());
            }
        }
        return true;
    }

    private boolean isWithinRadius(double lat1, double lon1, double lat2, double lon2) {
        double distance = calculateDistance(lat1, lon1, lat2, lon2);
        return distance <= this.LIMIT_RADIUS;
    }

    //Haversine formula implementation
    @Override
    public Double calculateDistance(double lat1, double lng1, double lat2, double lng2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lng2 - lng1);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c * 1000;
    }

    private void logCourierLocation(RequestType request){
        CourierLocationLog courierLocationLog = CourierLocationLog.builder()
                .courier(this.courierService.findByCourierID(request.getCourierID()).get())
                .time(request.getTime())
                .build();
        courierLocationLog.setLat(request.getLat());
        courierLocationLog.setLng(request.getLng());
        totalDistanceService.update(courierLocationLog);
        this.courierLocationLogService.save(courierLocationLog);
    }

    private void setStoreList(){
        if (this.storeList.isEmpty()){
            this.storeList = storeService.findAllStores();
        }
    }

}
