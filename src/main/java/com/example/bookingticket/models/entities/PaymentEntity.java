package com.example.bookingticket.models.entities;

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
    @Column(name = "PaymentID", nullable = false)
    private Integer paymentID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TicketID", nullable = false)
    private TicketEntity ticket;

    @Column(name = "PaymentMethod", nullable = false, length = 50)
    private String paymentMethod;

    @Column(name = "AmountPaid", nullable = false)
    private BigDecimal amountPaid;

    @Column(name = "PaymentDate", nullable = false)
    private LocalDateTime paymentDate;

    public Integer getTicketID() {
        return ticket != null ? ticket.getTicketID() : null;
    }
}
