package com.halitmancar.couriertracker.service.concrete;

import com.halitmancar.couriertracker.dto.CourierZoneEntryDto;
import com.halitmancar.couriertracker.mapping.ModelMapperManager;
import com.halitmancar.couriertracker.model.CourierZoneEntry;
import com.halitmancar.couriertracker.repository.CourierZoneEntryRepository;
import com.halitmancar.couriertracker.service.abstracts.CourierZoneEntryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CourierZoneEntryManager implements CourierZoneEntryService {
    private final Integer zoneEntryRefreshTime = 60;

    private CourierZoneEntryRepository repository;

    public CourierZoneEntryManager(CourierZoneEntryRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean save(CourierZoneEntry courierZoneEntry){
        if (checkLastZoneEntryOfCourier(courierZoneEntry)){
            this.repository.save(courierZoneEntry);
            return true;
        }
            return false;
    }

    @Override
    public List<CourierZoneEntryDto> getZoneEntries() {
        List<CourierZoneEntry> zoneEntries = repository.findAll();
        return zoneEntries.stream().map(zoneEntry -> ModelMapperManager.getMapper()
                .map(zoneEntry, CourierZoneEntryDto.class)).collect(Collectors.toList());
    }

    private boolean checkLastZoneEntryOfCourier(CourierZoneEntry courierZoneEntry){
        CourierZoneEntry lastZoneEntryOfCourier = repository.findFirstByCourierAndStoreOrderByTimeDesc
                (courierZoneEntry.getCourier(), courierZoneEntry.getStore());
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
            log.info("Courier is already logged in this zone in less than 1 minute.");
            return false;
        }
    }
}
