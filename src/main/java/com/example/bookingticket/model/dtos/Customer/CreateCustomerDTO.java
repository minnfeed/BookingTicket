package com.example.bookingticket.model.dtos.Customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerDTO {

    @NotBlank(message = "Customer Name is required")
    @Size(max = 100, message = "Customer Name must be less than or equal to 100 characters")
    private String customerName;

    @NotBlank(message = "Phone Number is required")
    @Size(max = 20, message = "Phone Number must be less than or equal to 20 characters")
    private String phoneNumber;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Size(max = 100, message = "Email must be less than or equal to 100 characters")
    private String email;
}