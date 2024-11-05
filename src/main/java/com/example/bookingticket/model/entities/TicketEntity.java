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
    @Column(name = "TicketID")
    private Integer ticketID;

    @ManyToOne
    @JoinColumn(name = "CustomerID", nullable = false)
    private CustomerEntity customer;

    @ManyToOne
    @JoinColumn(name = "TripID", nullable = false)
    private TripEntity trip;

    @ManyToOne
    @JoinColumn(name = "SeatID", nullable = false)
    private SeatEntity seat;

    @Column(name = "Price", nullable = false)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(name = "PaymentStatus", nullable = false)
    private PaymentStatus paymentStatus;
}
