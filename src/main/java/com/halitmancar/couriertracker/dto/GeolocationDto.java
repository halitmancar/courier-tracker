package com.halitmancar.couriertracker.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class GeolocationDto {
    private Double lat;
    private Double lng;
}
