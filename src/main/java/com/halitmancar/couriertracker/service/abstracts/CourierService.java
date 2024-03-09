package com.halitmancar.couriertracker.service.abstracts;

import com.halitmancar.couriertracker.model.Courier;

import java.util.Optional;

public interface CourierService {
    Optional<Courier> findByCourierID(Integer courierID);
}
