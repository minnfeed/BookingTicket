package com.example.bookingticket.models.dtos.Seat;

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
public class CreateSeatDTO {
    @NotNull(message = " Seat ID can't be null")
    Integer seatID;

    @NotNull(message = " Bus ID can't be null")
    Integer bus;

    @NotBlank(message = " Seat Number can't be null")
    String seatNumber;

    @NotBlank(message = " Seat Status can't be null")
    String seatStatus;
}
