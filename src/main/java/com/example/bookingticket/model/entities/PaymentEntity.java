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
@Table(name = "Payment")
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PaymentID")
    private Integer paymentID;

    @ManyToOne
    @JoinColumn(name = "TicketID", nullable = false)
    private TicketEntity ticket;

    @Column(name = "PaymentMethod", nullable = false, length = 50)
    private String paymentMethod;

    @Column(name = "AmountPaid", nullable = false)
    private BigDecimal amountPaid;

    @Column(name = "PaymentDate", nullable = false)
    private LocalDateTime paymentDate;
}
