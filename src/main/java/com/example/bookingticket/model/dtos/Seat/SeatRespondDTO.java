package com.example.bookingticket.model.dtos.Seat;

import com.example.bookingticket.model.entities.SeatStatus;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeatRespondDTO {

    private Integer seatID;
    private Integer busID;
    private String seatNumber;
    private SeatStatus seatStatus;
}