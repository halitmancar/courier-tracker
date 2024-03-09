package com.halitmancar.couriertracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "courier")
@SequenceGenerator(name = "courier_seq_gen", sequenceName = "courier_id_sequence",initialValue = 1, allocationSize = 1)
public class Courier {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "courier_seq_gen")
    @Column(name = "id")
    @Getter
    @Setter
    private Integer id;

    @Column(name = "courier_name")
    @Getter
    @Setter
    private String courierName;

    @Column(name = "license_plate")
    @Getter
    @Setter
    private String licensePlate;

    @Column(name = "total_travel_distance")
    @Getter
    @Setter
    private Double totalTravelDistance;

    @OneToMany(mappedBy = "courier")
    @Getter
    @Setter
    private Set<CourierZoneEntry> courierZoneEntries = new LinkedHashSet<CourierZoneEntry>();

    @OneToMany(mappedBy = "courier")
    @Getter
    @Setter
    private Set<CourierLocationLog> courierLocationLogs = new LinkedHashSet<>();

    @OneToOne(mappedBy = "courier")
    @Getter
    @Setter
    private TotalDistance totalDistance;
}
