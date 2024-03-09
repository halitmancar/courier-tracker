package com.halitmancar.couriertracker.service.concrete;

import com.halitmancar.couriertracker.model.Store;
import com.halitmancar.couriertracker.repository.StoreRepository;
import com.halitmancar.couriertracker.service.abstracts.StoreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreManager implements StoreService {

    private StoreRepository repository;

    public StoreManager(StoreRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Store> findAllStores() {
        return this.repository.findAll();
    }
}
