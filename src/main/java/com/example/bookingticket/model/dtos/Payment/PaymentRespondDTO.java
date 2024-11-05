package com.example.bookingticket.model.dtos.Payment;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRespondDTO {

    private Integer paymentID;
    private Integer ticketID;
    private String paymentMethod;
    private BigDecimal amountPaid;
    private LocalDateTime paymentDate;
}