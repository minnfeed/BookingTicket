package models.dtos.Ticket;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class CreateTicketDTO {
    @NotNull(message = " Ticket ID can't be null")
    Integer ticketID;

    @NotNull(message = " Customer ID can't be null")
    Integer customer;

    @NotNull(message = " Trip ID can't be null")
    Integer trip;

    @NotNull(message = " Seat ID can't be null")
    Integer seat;

    @NotNull(message = " Price can't be null")
    @Size(min = 0)
    BigDecimal price;

    @NotBlank(message = " Payment Status can't be null")
    String paymentStatus;

}
