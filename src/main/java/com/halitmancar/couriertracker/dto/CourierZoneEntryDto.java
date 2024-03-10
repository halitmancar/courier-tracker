package com.halitmancar.couriertracker.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourierZoneEntryDto {
    @JsonIgnore
    private Integer id;
    private Instant time;
    private Integer courierID;
    private Integer storeID;
    private Double lat;
    private Double lng;
}
