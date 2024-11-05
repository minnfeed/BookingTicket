package com.example.bookingticket.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Customer")
public class CustomerEntity {

    @Id
    @Column( name = "CustomerID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerID;

    @Column(name = "CustomerName", nullable = false, length = 100)
    private String customerName;

    @Column(name = "PhoneNumber", nullable = false, length = 20)
    private String phoneNumber;

    @Column(name = "Email", nullable = false, length = 100)
    private String email;

    @OneToOne(mappedBy = "customer")
    private UserAccountEntity userAccount;

}
