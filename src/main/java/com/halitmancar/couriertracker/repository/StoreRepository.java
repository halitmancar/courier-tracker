package com.halitmancar.couriertracker.repository;

import com.halitmancar.couriertracker.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Integer> {
}
