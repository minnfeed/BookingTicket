package com.example.bookingticket.models.dtos.Bus;

import com.example.bookingticket.models.entities.BusType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusRespondDTO {

    private Integer busID;
    private Integer busCompany;
    private String licensePlate;
    private Integer seatCount;
    private BusType busType;

    @Override
    public String toString() {
        return "{" +
                "Bus ID: " + busID +
                ", Bus Company ID: " + busCompany +
                ", License Plate: " + licensePlate +
                ", Seat Count: " + seatCount +
                ", Bus Type: " + busType +
                "}";
    }
}
