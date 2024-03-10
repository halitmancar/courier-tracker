package com.halitmancar.couriertracker.service.abstracts;

import com.halitmancar.couriertracker.dto.CourierZoneEntryDto;
import com.halitmancar.couriertracker.model.CourierZoneEntry;

import java.util.List;

public interface CourierZoneEntryService {
    void save(CourierZoneEntry courierZoneEntry);
    List<CourierZoneEntryDto> getZoneEntries();
}
