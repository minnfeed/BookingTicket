package com.example.bookingticket.model.dtos.Seat;

import com.example.bookingticket.model.entities.SeatStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateSeatDTO {

    @NotNull(message = "Bus ID is required")
    private Integer busID;

    @NotBlank(message = "Seat Number is required")
    @Size(max = 5, message = "Seat Number must be at most 5 characters")
    private String seatNumber;

    @NotNull(message = "Seat Status is required")
    private SeatStatus seatStatus;
}