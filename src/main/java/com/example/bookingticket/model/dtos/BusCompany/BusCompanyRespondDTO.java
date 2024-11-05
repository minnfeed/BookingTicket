package com.example.bookingticket.model.dtos.BusCompany;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusCompanyRespondDTO {

    private Integer busCompanyID;
    private String busCompanyName;
    private String address;
    private String phoneNumber;
}