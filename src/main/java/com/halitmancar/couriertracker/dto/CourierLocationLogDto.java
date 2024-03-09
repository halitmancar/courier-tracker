package com.halitmancar.couriertracker.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourierLocationLogDto {
    private Instant time;
    private Integer courierID;
    private Double lat;
    private Double lng;
}
