package com.example.bookingticket.model.dtos.UserAccount;

import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountRespondDTO {
    private String phoneNumber;
    private String role;
}