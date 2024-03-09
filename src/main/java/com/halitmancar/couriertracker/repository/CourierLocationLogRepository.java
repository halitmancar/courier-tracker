package com.halitmancar.couriertracker.repository;

import com.halitmancar.couriertracker.model.CourierLocationLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourierLocationLogRepository extends JpaRepository<CourierLocationLog, Integer> {
    List<CourierLocationLog> findAllByCourierId(Integer courierID);
}
