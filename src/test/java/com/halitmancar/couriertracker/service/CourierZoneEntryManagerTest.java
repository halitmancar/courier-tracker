package com.halitmancar.couriertracker.service;

import com.halitmancar.couriertracker.model.Courier;
import com.halitmancar.couriertracker.model.CourierZoneEntry;
import com.halitmancar.couriertracker.model.Store;
import com.halitmancar.couriertracker.repository.CourierZoneEntryRepository;
import com.halitmancar.couriertracker.service.concrete.CourierZoneEntryManager;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.Instant;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
public class CourierZoneEntryManagerTest {
    @Mock
    private CourierZoneEntryRepository courierZoneEntryRepository;
    @InjectMocks
    private CourierZoneEntryManager courierZoneEntryManager;

    @Test
    void shouldLogZoneEntrySuccessfully(){
        when(courierZoneEntryRepository.findFirstByCourierAndStoreOrderByTimeDesc(getFakeCourier(), getFakeStore()))
                .thenReturn(getLastSavedZoneEntry());
        boolean result = courierZoneEntryManager.save(getNewValidZoneEntry());
        assertThat(result==true);
    }

    @Test
    void shouldNotLogZoneEntryBecauseOfRefreshTime(){
        when(courierZoneEntryRepository.findFirstByCourierAndStoreOrderByTimeDesc(getFakeCourier(), getFakeStore()))
                .thenReturn(getLastSavedZoneEntry());
        boolean result = courierZoneEntryManager.save(getNewInvalidZoneEntry());
        assertThat(result==false);
    }

    public static CourierZoneEntry getNewValidZoneEntry(){
        CourierZoneEntry courierZoneEntry = CourierZoneEntry.builder()
                .courier(getFakeCourier())
                .store(getFakeStore())
                .time(Instant.ofEpochSecond(1710103442))
                .build();
        courierZoneEntry.setLat(41.02158);
        courierZoneEntry.setLng(29.01297);
        return courierZoneEntry;
    }

    private CourierZoneEntry getNewInvalidZoneEntry(){
        CourierZoneEntry courierZoneEntry = CourierZoneEntry.builder()
                .courier(getFakeCourier())
                .store(getFakeStore())
                .time(Instant.ofEpochSecond(1710103439))
                .build();
        courierZoneEntry.setLat(41.02158);
        courierZoneEntry.setLng(29.01297);
        return courierZoneEntry;
    }

    private CourierZoneEntry getLastSavedZoneEntry(){
        CourierZoneEntry courierZoneEntry = CourierZoneEntry.builder()
                .courier(getFakeCourier())
                .store(getFakeStore())
                .time(Instant.ofEpochSecond(1710103381))
                .build();
        courierZoneEntry.setLat(41.02258);
        courierZoneEntry.setLng(29.01177);
        return courierZoneEntry;
    }

    public static Courier getFakeCourier(){
        return Courier.builder()
                .id(1)
                .courierName("Halit Mancar")
                .licensePlate("20MMM20")
                .courierZoneEntries(new HashSet<>())
                .courierLocationLogs(new HashSet<>())
                .build();
    }

    public static Store getFakeStore(){
        Store store = Store.builder()
                .id(1)
                .storeName("AnkaMall 5M Migros")
                .courierZoneEntries(new HashSet<>())
                .build();

        store.setLat(41.02148);
        store.setLng(29.01287);
        return store;
    }
}
