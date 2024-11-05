package com.example.bookingticket.model.dtos.BusCompany;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateBusCompanyDTO {

    @NotBlank(message = "Bus Company Name is required")
    @Size(max = 100, message = "Bus Company Name must be less than or equal to 100 characters")
    private String busCompanyName;

    @NotBlank(message = "Address is required")
    @Size(max = 255, message = "Address must be less than or equal to 255 characters")
    private String address;

    @NotBlank(message = "Phone Number is required")
    @Size(max = 20, message = "Phone Number must be less than or equal to 20 characters")
    private String phoneNumber;
}