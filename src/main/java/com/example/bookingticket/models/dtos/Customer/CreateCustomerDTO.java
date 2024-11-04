package com.example.bookingticket.models.dtos.Customer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class CreateCustomerDTO {
    @NotNull(message = " Customer ID can't be null")
    Integer customerID;

    @NotBlank(message = " Customer Name can't be null")
    String customerName;

    @NotBlank(message = " Phone Number can't be null")
    String phoneNumber;

    @NotBlank(message = " Email can't be null")
    String email;

}
