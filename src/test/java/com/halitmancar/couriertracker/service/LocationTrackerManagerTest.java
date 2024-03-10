package com.halitmancar.couriertracker.service;

import com.halitmancar.couriertracker.controller.LocationTrackerControllerTest;
import com.halitmancar.couriertracker.dto.RequestType;
import com.halitmancar.couriertracker.model.Courier;
import com.halitmancar.couriertracker.model.CourierLocationLog;
import com.halitmancar.couriertracker.model.CourierZoneEntry;
import com.halitmancar.couriertracker.model.Store;
import com.halitmancar.couriertracker.service.abstracts.*;
import com.halitmancar.couriertracker.service.concrete.LocationTrackerManager;
import com.halitmancar.couriertracker.service.proxy.TotalDistanceProxy;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@ActiveProfiles("test")
public class LocationTrackerManagerTest {
    @Mock
    private StoreService storeService;
    @Mock
    private CourierService courierService;
    @Mock
    private TotalDistanceProxy totalDistanceService;
    @Mock
    private CourierLocationLogService courierLocationLogService;
    @Mock
    private CourierZoneEntryService courierZoneEntryService;
    @InjectMocks
    private LocationTrackerManager locationTrackerManager;

    @Test
    void shouldLogAZoneEntry(){
        Optional<Courier> courier = Optional.ofNullable(CourierZoneEntryManagerTest.getFakeCourier());

        when(storeService.findAllStores()).thenReturn(getStoreList());
        when(courierService.findByCourierID(getFakeRequest().getCourierID())).thenReturn(courier);
        when(courierZoneEntryService.save(CourierZoneEntryManagerTest.getNewValidZoneEntry())).thenReturn(true);

        locationTrackerManager.checkAllZones(getFakeRequest());

        verify(courierZoneEntryService).save(any(CourierZoneEntry.class));
        verify(totalDistanceService).update(any(CourierLocationLog.class));
        verify(courierLocationLogService).save(any(CourierLocationLog.class));
    }

    private List<Store> getStoreList(){
        Store store1 = CourierZoneEntryManagerTest.getFakeStore();
        Store store2 = CourierZoneEntryManagerTest.getFakeStore();
        store2.setLat(40.986106);
        store2.setLng(29.1161293);
        store2.setStoreName("Novada MMM Migros");
        return Arrays.asList(store1,store2);
    }

    private RequestType getFakeRequest(){
        return RequestType.builder()
                .lat(41.02158)
                .lng(29.01297)
                .time(Instant.ofEpochSecond(1710103442))
                .courierID(1)
                .build();
    }


}
