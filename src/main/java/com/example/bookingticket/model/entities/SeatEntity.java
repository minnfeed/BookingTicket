package com.example.bookingticket.model.entities;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "seat")
public class SeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SeatID")
    private Integer seatID;

    @ManyToOne
    @JoinColumn(name = "BusID", nullable = false)
    private BusEntity bus;

    @Column(name = "SeatNumber", nullable = false, length = 5)
    private String seatNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "SeatStatus", nullable = false)
    private SeatStatus seatStatus;
}
