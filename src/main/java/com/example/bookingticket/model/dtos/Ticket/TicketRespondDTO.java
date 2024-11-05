package com.example.bookingticket.model.dtos.Ticket;

import com.example.bookingticket.model.entities.PaymentStatus;
import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketRespondDTO {

    private Integer ticketID;
    private Integer customerID;
    private Integer tripID;
    private Integer seatID;
    private BigDecimal price;
    private PaymentStatus paymentStatus;
}