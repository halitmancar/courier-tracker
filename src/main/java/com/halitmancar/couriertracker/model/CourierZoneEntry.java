package com.halitmancar.couriertracker.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "courier_zone_entry")
@SequenceGenerator(name = "courier_zone_entry_seq_gen", sequenceName = "courier_zone_entry_id_sequence",initialValue = 1, allocationSize = 1)
public class CourierZoneEntry extends Geolocation{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "courier_zone_entry_seq_gen")
    @Column(name = "id")
    @Getter
    @Setter
    private Integer id;

    @Column(name = "time")
    @Getter
    @Setter
    private Instant time;

    @ManyToOne
    @JoinColumn(name = "courier_id", referencedColumnName = "id")
    @Getter
    @Setter
    private Courier courier;

    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    @Getter
    @Setter
    private Store store;
}
