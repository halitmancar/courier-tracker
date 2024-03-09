package com.halitmancar.couriertracker.service.concrete;

import com.halitmancar.couriertracker.model.CourierZoneEntry;
import com.halitmancar.couriertracker.repository.CourierZoneEntryRepository;
import com.halitmancar.couriertracker.service.abstracts.CourierZoneEntryService;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;

@Service
public class CourierZoneEntryManager implements CourierZoneEntryService {
    private final Integer zoneEntryRefreshTime = 60;
    private CourierZoneEntryRepository repository;

    public CourierZoneEntryManager(CourierZoneEntryRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(CourierZoneEntry courierZoneEntry){
        if (checkLastZoneEntryOfCourier(courierZoneEntry))
            this.repository.save(courierZoneEntry);
    }

    private boolean checkLastZoneEntryOfCourier(CourierZoneEntry courierZoneEntry){
        CourierZoneEntry lastZoneEntryOfCourier = repository.findFirstByCourierOrderByTimeDesc(courierZoneEntry.getCourier());
        Instant lastZoneEntryTime;
        if (lastZoneEntryOfCourier!=null){
            lastZoneEntryTime = lastZoneEntryOfCourier.getTime();
        } else {
            lastZoneEntryTime = Instant.MIN;
        }
        Duration duration = Duration.between(lastZoneEntryTime, courierZoneEntry.getTime());
        if (duration.toSeconds() > this.zoneEntryRefreshTime){
            return true;
        } else {
            return false;
        }
    }
}
