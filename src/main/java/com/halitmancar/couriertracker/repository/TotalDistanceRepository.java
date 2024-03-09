package com.halitmancar.couriertracker.repository;

import com.halitmancar.couriertracker.model.Courier;
import com.halitmancar.couriertracker.model.TotalDistance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TotalDistanceRepository extends JpaRepository<TotalDistance, Integer> {
    TotalDistance findByCourier(Courier courier);
    TotalDistance findTotalDistancedByCourierId(Integer courierID);
}
