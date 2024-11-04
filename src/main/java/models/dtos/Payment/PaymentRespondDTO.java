package models.dtos.Payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class PaymentRespondDTO {
    Integer paymentID;
    Integer ticket;
    String paymentMethod;
    BigDecimal amountPaid;
    LocalDateTime paymentDate;
}
