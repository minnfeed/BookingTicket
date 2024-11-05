package com.example.bookingticket.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payment")
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymentid")
    private int paymentId;

    @ManyToOne
    @JoinColumn(name = "ticketid", nullable = false)
    private TicketEntity ticket;

    @Column(name = "paymentmethod", nullable = false)
    private String paymentMethod;

    @Column(name = "amountpaid", nullable = false)
    private BigDecimal amountPaid;

    @Column(name = "paymentdate", nullable = false)
    private LocalDateTime paymentDate;
}
