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
    @Column(name = "phonenumber", nullable = false)
    private String phoneNumber;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;
    @OneToOne
    @MapsId
    @JoinColumn(name = "phonenumber")
    private CustomerEntity customer;
}