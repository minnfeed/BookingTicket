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
    @Column(name = "seatid")
    private int seatId;

    @ManyToOne
    @JoinColumn(name = "busid", nullable = false)
    private TourbusEntity bus;

    @Column(name = "seatnumber", nullable = false)
    private String seatNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "seatstatus", nullable = false)
    private SeatStatus seatStatus;
}
