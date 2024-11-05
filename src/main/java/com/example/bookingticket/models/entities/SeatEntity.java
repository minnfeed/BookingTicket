package com.example.bookingticket.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Seat")
public class SeatEntity {
    @Id
    @Column(name = "SeatID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seatID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "BusID", nullable = false)
    private BusEntity bus;

    @Column(name = "SeatNumber", nullable = false, length = 5)
    private String seatNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "SeatStatus", nullable = false)
    private SeatStatus seatStatus;

    public  Integer getBusID() {
        return bus != null ? bus.getBusID() : null;
    }
}
