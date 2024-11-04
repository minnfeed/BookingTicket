package com.example.bookingticket.models.dtos.Bus;

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
    private Integer busCompanyID;
    private  String licensePlate;
    private Integer seatCount;
    private String busType;

//    @Override
//    public String toString() {
//        return "{" +
//                "Bus ID:" + busID +
//                "\nBus Company ID:" + busCompany +
//                "\nLicense Plate:" + licensePlate +
//                "\nSeat Count:" + seatCount +
//                "\nBus Type:" + busType +
//                "}";
//    }
}

