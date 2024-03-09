package com.halitmancar.couriertracker.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TotalDistanceDto {
    private Integer courierId;
    private Double totalDistanceTravelled;
    private Double lastSeenLat;
    private Double lastSeenLng;
}
