package com.example.bookingticket.models.dtos.BusCompany;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class CreateBusCompanyDTO {
    @NotNull(message = " Bus Company ID can't be null")
    Integer busCompanyID;

    @NotBlank(message = " Bus Company Name can't be null")
    String busCompanyName;

    @NotBlank(message = " Address can't be null")
    String address;

    @NotBlank(message = " Phone Number can't be null")
    @Size(min = 10, max = 12, message = "Phone number must be between 10 and 12 characters")
    String phoneNumber;



}
