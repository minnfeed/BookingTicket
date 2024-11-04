package com.example.bookingticket.models.dtos.BusCompany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class BusCompanyRespondDTO {
    Integer busCompanyID;
    String busCompanyName;
    String address;
    String phoneNumber;
}
