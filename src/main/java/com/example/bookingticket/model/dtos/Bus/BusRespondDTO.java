package com.example.bookingticket.model.dtos.Bus;

import com.example.bookingticket.model.entities.BusType;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusRespondDTO {

    private Integer busID;
    private String licensePlate;
    private Integer seatCount;
    private BusType busType;
    private Integer busCompanyId;
}
