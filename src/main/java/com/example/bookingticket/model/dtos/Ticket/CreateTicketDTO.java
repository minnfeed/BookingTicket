package com.example.bookingticket.model.dtos.Ticket;

import com.example.bookingticket.model.entities.PaymentStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateTicketDTO {

    @NotNull(message = "Customer ID is required")
    private Integer customerID;

    @NotNull(message = "Trip ID is required")
    private Integer tripID;

    @NotNull(message = "Seat ID is required")
    private Integer seatID;

    @NotNull(message = "Price is required")
    private BigDecimal price;

    @NotBlank(message = " Payment Status can't be null")
    PaymentStatus paymentStatus;

}
