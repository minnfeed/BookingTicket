package com.example.bookingticket.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ticket")
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticketid")
    private int ticketId;

    @ManyToOne
    @JoinColumn(name = "customerid", nullable = false)
    private CustomerEntity customer;

    @ManyToOne
    @JoinColumn(name = "tripid", nullable = false)
    private TripEntity trip;

    @ManyToOne
    @JoinColumn(name = "seatid", nullable = false)
    private SeatEntity seat;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(name = "paymentstatus", nullable = false)
    private PaymentStatus paymentStatus;
}
