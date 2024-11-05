package com.example.bookingticket.model.dtos.Trip;


import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateTripDTO {

    @NotNull(message = "Bus ID is required")
    private Integer busID;

    @NotNull(message = "Departure location is required")
    private String departureLocation;

    @NotNull(message = "Arrival location is required")
    private String arrivalLocation;

    @NotNull(message = "Departure time is required")
    private LocalDateTime departureTime;

    @NotNull(message = "Arrival time is required")
    private LocalDateTime arrivalTime;
}