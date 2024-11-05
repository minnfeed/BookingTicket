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
@Table(name = "Bus")
public class BusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BusID", nullable = false)
    private Integer busID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "BusCompanyID", nullable = false)
    private BusCompanyEntity busCompany;

    @Column(name = "LicensePlate", nullable = false, length = 20)
    private String licensePlate;

    @Column(name = "SeatCount", nullable = false)
    private Integer seatCount;


    @Enumerated(EnumType.STRING)
    @Column(name = "BusType", nullable = false)
    private BusType busType;

    @OneToMany(mappedBy = "bus")
    private List<SeatEntity> seats;

    @OneToMany(mappedBy = "bus")
    private List<TripEntity> trips;

    // Hàm trả về BusCompanyID
//    public Integer getBusCompanyID() {
//        return busCompany != null ? busCompany.getBusCompanyID() : null;
//    }

    // Override toString để in thông tin chi tiết
    @Override
    public String toString() {
        return "{" +
                "Bus ID: " + busID +
                ", Bus Company ID: " + (busCompany != null ? busCompany.getBusCompanyID() : null) +
                ", License Plate: " + licensePlate +
                ", Seat Count: " + seatCount +
                ", Bus Type: " + busType +
                "}";
    }

}
