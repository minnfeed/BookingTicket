package models.dtos.Payment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.relational.core.sql.In;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class CreatePaymentDTO {
    @NotNull(message = " Payment ID can't be null")
    Integer paymentID;

    @NotNull(message = " Ticket ID can't be null")
    Integer ticket;

    @NotBlank(message = " Payment method can't be null")
    String paymentMethod;

    @NotNull(message = " Amount Paid can't be null")
    @Size(min = 0)
    BigDecimal amountPaid;

    @NotBlank(message = " Payment Date can't be null")
    LocalDateTime paymentDate;


}
