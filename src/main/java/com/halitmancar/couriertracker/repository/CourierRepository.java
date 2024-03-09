package com.halitmancar.couriertracker.repository;

import com.halitmancar.couriertracker.model.Courier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourierRepository extends JpaRepository<Courier, Integer> {
}
