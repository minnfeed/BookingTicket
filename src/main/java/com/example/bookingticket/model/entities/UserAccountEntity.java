package com.example.bookingticket.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "useraccount")
public class UserAccountEntity {
    @Id
    @Column(name = "PhoneNumber", length = 50)
    private String phoneNumber;

    @Column(name = "Password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "Role", nullable = false)
    private Role role;

    @OneToOne
    @MapsId
    @JoinColumn(name = "phoneNumber")
    private CustomerEntity customer;
}