package com.example.bookingticket.model.dtos.UserAccount;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUseAccountDTO {
    private String phoneNumber;
    private String password;
    private String role;
}