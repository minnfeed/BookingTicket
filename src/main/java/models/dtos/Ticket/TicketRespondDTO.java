package models.dtos.Ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class TicketRespondDTO {
    Integer ticketID;
    Integer customer;
    Integer trip;
    Integer seat;
    BigDecimal price;
    String paymentStatus;
}
