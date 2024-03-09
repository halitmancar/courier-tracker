package com.halitmancar.couriertracker.repository;

import com.halitmancar.couriertracker.model.Courier;
import com.halitmancar.couriertracker.model.CourierZoneEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourierZoneEntryRepository extends JpaRepository<CourierZoneEntry, Integer> {
    CourierZoneEntry findFirstByCourierOrderByTimeDesc(Courier courier);
}
