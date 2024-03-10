package com.halitmancar.couriertracker.test;

import com.halitmancar.couriertracker.dto.GeolocationDto;
import com.halitmancar.couriertracker.dto.RequestType;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component
public class RequestGenerator implements RequestGeneratorService {

    private RequestGeneratorClient requestGeneratorClient;
    private final Double MIN_LAT = 40.9632463;
    private final Double MAX_LAT = 41.055783;
    private final Double MIN_LNG = 28.6552262;
    private final Double MAX_LNG = 29.1244229;
    private boolean firstStart = true;
    private Integer COURIER_ID = 1;
    private Instant TIME = Instant.now();
    private Map<Integer, GeolocationDto> courierLocations = new HashMap<>();
    private Boolean testStarted = false;

    public RequestGenerator(RequestGeneratorClient requestGeneratorClient) {
        this.requestGeneratorClient = requestGeneratorClient;
    }

    @Override
    public void startSendingRequests() {
        this.testStarted = Boolean.TRUE;
        while (testStarted) {
            requestGeneratorClient.sendCourierLog(generateNewRequest());
            COURIER_ID++;
        }
    }

    @Override
    public void stopSendingRequests(){
        this.testStarted = Boolean.FALSE;
    }

    private RequestType generateNewRequest() {
        RequestType request = RequestType.builder()
                .courierID(COURIER_ID)
                .time(TIME)
                .lat(courierLocations.get(COURIER_ID).getLat())
                .lng(courierLocations.get(COURIER_ID).getLng())
                .build();
        if (COURIER_ID==10){
            COURIER_ID=0;
            TIME = TIME.plusSeconds(10);
            changeCourierLocations();
        }
        return request;
    }

    @Override
    public void setCourierFirstLocations(){
        if (!firstStart) return;
        courierLocations.put(1, GeolocationDto.builder().lat(40.968191).lng(29.096219).build());
        courierLocations.put(2, GeolocationDto.builder().lat(41.044927).lng(29.016921).build());
        courierLocations.put(3, GeolocationDto.builder().lat(41.004844).lng(28.667931).build());
        courierLocations.put(4, GeolocationDto.builder().lat(40.980769).lng(29.086387).build());
        courierLocations.put(5, GeolocationDto.builder().lat(40.980059).lng(29.106996).build());
        courierLocations.put(6, GeolocationDto.builder().lat(40.998191).lng(29.126219).build());
        courierLocations.put(7, GeolocationDto.builder().lat(40.975927).lng(29.103921).build());
        courierLocations.put(8, GeolocationDto.builder().lat(41.000014).lng(28.687931).build());
        courierLocations.put(9, GeolocationDto.builder().lat(41.088769).lng(29.002387).build());
        courierLocations.put(10, GeolocationDto.builder().lat(40.947659).lng(29.036996).build());
        firstStart=Boolean.FALSE;
    }

    private void changeCourierLocations(){
        for (Map.Entry<Integer, GeolocationDto> entry : courierLocations.entrySet()){
            Double newLat = changeLocation(entry.getValue().getLat());
            Double newLng = changeLocation(entry.getValue().getLng());
            entry.getValue().setLat(newLat);
            entry.getValue().setLng(newLng);
        }
    }

    private Double changeLocation(Double latOrLng){
        Random random = new Random();
        Double change = 0.001 + 0.001 * random.nextDouble();
        if (random.nextDouble()>0.5)
            change *= -1;
        return latOrLng+change;
    }
}
