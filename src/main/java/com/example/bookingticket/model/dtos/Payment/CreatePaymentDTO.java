package com.example.bookingticket.model.dtos.Payment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatePaymentDTO {

    @NotNull(message = "Ticket ID is required")
    private Integer ticketID;

    @NotBlank(message = "Payment Method is required")
    private String paymentMethod;

    @NotNull(message = "Amount Paid is required")
    @Positive(message = "Amount Paid must be positive")
    private BigDecimal amountPaid;
}
