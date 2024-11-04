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
    private Integer ticketID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CustomerID", nullable = false)
    private CustomerEntity customer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TripID", nullable = false)
    private TripEntity trip;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SeatID", nullable = false)
    private SeatEntity seat;

    @Column(name = "Price", nullable = false)
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

