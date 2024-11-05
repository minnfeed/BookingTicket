package com.example.bookingticket.model.dtos.Customer;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRespondDTO {

    private Integer customerID;
    private String customerName;
    private String phoneNumber;
    private String email;
}