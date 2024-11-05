package com.example.bookingticket.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tourbus")

public class TourbusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "busid")
    private int busId;

    @ManyToOne
    @JoinColumn(name = "buscompanyid", nullable = false)
    private BusCompanyEntity busCompany;

    @Column(name = "licenseplate", nullable = false, unique = true)
    private String licensePlate;

    @Column(name = "seatcount", nullable = false)
    private int seatCount;

    @Enumerated(EnumType.STRING)
    @Column(name = "bustype", nullable = false)
    private BusType busType;
}
