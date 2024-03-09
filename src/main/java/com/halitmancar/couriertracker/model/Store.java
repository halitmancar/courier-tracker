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
@Table(name = "store")
@SequenceGenerator(name = "store_seq_gen", sequenceName = "store_id_sequence",initialValue = 1, allocationSize = 1)
public class Store extends Geolocation{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "store_seq_gen")
    @Column(name = "id")
    @Getter
    @Setter
    private Integer id;

    @Column(name = "store_name")
    @Getter
    @Setter
    private String storeName;

    @OneToMany(mappedBy = "store")
    @Getter
    @Setter
    private Set<CourierZoneEntry> courierZoneEntries = new LinkedHashSet<CourierZoneEntry>();

}
