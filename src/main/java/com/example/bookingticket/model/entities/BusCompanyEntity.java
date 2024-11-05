package com.example.bookingticket.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "buscompany")
public class BusCompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BusCompanyID")
    private Integer busCompanyID;

    @Column(name = "BusCompanyName",nullable = false, length = 100)
    private String busCompanyName;

    @Column(name = "Address", nullable = false, length = 255)
    private String address;

    @Column(name = "PhoneNumber", nullable = false, length = 20, unique = true)
    private String phoneNumber;

    @OneToMany(mappedBy = "busCompany", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BusEntity> buses;
}
