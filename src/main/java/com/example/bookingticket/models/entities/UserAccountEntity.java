package com.example.bookingticket.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "UserAccount")
public class UserAccountEntity {
    @Id
    @Column(name = "PhoneNumber", nullable = false, length = 50)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String phoneNumber;

    @Column(name = "Password", nullable = false, length = 50)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "Role", nullable = false)
    private  Role role;

    @OneToOne
    @MapsId
    @JoinColumn(name = "PhoneNumber", referencedColumnName = "PhoneNumber")
    private CustomerEntity customer;
}
