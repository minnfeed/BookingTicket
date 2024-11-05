package com.example.bookingticket.models.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bus")
public class BusEntity {
    @Id
    @Column(name = "BusID", nullable = false)
    private Integer busID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "BusCompanyID", nullable = false)
    private BusCompanyEntity busCompany;

    @Column(name = "LicensePlate", nullable = false, length = 20)
    private  String licensePlate;

    @Column(name = "SeatCount", nullable = false)
    private Integer seatCount;

    @Enumerated(EnumType.STRING)
    @Column(name = "BusType", nullable = false)
    private BusType busType;

    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SeatEntity> seats;

    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TripEntity> trips;

    public Integer getBusCompanyID() {
        return  busCompany != null ? busCompany.getBusCompanyID() : null;
    }

    @Override
    public String toString() {
        return "{" +
                "Bus ID:" + getBusID() +
                "\nBus Company ID:" + getBusCompanyID() +
                "\nLicense Plate:" + getLicensePlate() +
                "\nSeat Count:" + getSeatCount() +
                "\nBus Type:" + getBusType() +
                "}";
    }
}
