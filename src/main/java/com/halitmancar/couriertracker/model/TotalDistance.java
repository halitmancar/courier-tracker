package com.halitmancar.couriertracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "total_distance")
@SequenceGenerator(name = "total_distance_seq_gen", sequenceName = "total_distance_id_sequence",initialValue = 1, allocationSize = 1)
public class TotalDistance {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "total_distance_seq_gen")
    @Column(name = "id")
    @Getter
    @Setter
    private Integer id;

    @Column(name = "total_distance_travelled")
    @Getter
    @Setter
    private Double totalDistanceTravelled;

    @Column(name = "last_seen_lat")
    @Getter
    @Setter
    private Double lastSeenLat;

    @Column(name = "last_seen_lng")
    @Getter
    @Setter
    private Double lastSeenLng;

    @OneToOne
    @JoinColumn(name = "courier_id")
    private Courier courier;
}
