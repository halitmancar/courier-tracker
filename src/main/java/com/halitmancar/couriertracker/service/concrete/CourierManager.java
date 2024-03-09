package com.halitmancar.couriertracker.service.concrete;

import com.halitmancar.couriertracker.model.Courier;
import com.halitmancar.couriertracker.repository.CourierRepository;
import com.halitmancar.couriertracker.service.abstracts.CourierService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourierManager implements CourierService {

    private CourierRepository courierRepository;

    public CourierManager(CourierRepository courierRepository) {
        this.courierRepository = courierRepository;
    }

    @Override
    public Optional<Courier> findByCourierID(Integer courierID) {
        return courierRepository.findById(courierID);
    }
}
