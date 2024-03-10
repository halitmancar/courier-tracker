package com.halitmancar.couriertracker.repository;

import com.halitmancar.couriertracker.model.Courier;
import com.halitmancar.couriertracker.model.CourierZoneEntry;
import com.halitmancar.couriertracker.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourierZoneEntryRepository extends JpaRepository<CourierZoneEntry, Integer> {
    CourierZoneEntry findFirstByCourierAndStoreOrderByTimeDesc(Courier courier, Store store);
}
