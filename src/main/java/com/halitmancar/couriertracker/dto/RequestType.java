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
public class RequestType {
    private Integer courierID;
    private Instant time;
    private Double lat;
    private Double lng;
}
