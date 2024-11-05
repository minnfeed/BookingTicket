package com.example.bookingticket.model.dtos.Bus;

import com.example.bookingticket.model.entities.BusType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateBusDTO {

    @NotBlank(message = "License Plate is required")
    @Size(max = 20, message = "License Plate must be less than or equal to 20 characters")
    private String licensePlate;

    @NotNull(message = "Seat Count is required")
    private Integer seatCount;

    @NotNull(message = "Bus Type is required")
    private BusType busType;

    @NotNull(message = "Bus Company ID is required")
    private Integer busCompanyId;
}


