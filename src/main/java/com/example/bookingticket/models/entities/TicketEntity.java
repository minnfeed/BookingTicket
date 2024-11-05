package com.example.bookingticket.models.entities;

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
    @Column(name = "TicketID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CustomerID", referencedColumnName ="CustomerID", nullable = false)
    private CustomerEntity customer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TripID", referencedColumnName ="TripID", nullable = false)
    private TripEntity trip;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SeatID", referencedColumnName ="SeatID", nullable = false)
    private SeatEntity seat;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(name = "PaymentStatus", nullable = false)
    private PaymentStatus paymentStatus;

    public Integer getCustomerID() {
        return customer != null ? customer.getCustomerID() : null;
    }

    public Integer getTripID() {
        return  trip != null ? trip.getTripID() : null;
    }

    public Integer getSeatID() {
        return seat != null ? seat.getSeatID() : null;
    }
}

