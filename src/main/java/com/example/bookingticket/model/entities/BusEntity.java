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
@Table(name = "Bus")
public class BusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BusID")
    private Integer busID;

    @ManyToOne
    @JoinColumn(name = "BusCompanyID", nullable = false)
    private BusCompanyEntity busCompany;

    @Column(name = "LicensePlate", nullable = false, length = 20, unique = true)
    private String licensePlate;

    @Column(name = "SeatCount", nullable = false)
    private Integer seatCount;

    @Enumerated(EnumType.STRING)
    @Column(name = "BusType", nullable = false)
    private BusType busType;

    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SeatEntity> seats;
}

