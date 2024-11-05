package com.example.bookingticket.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerID")
    private Integer customerID;

    @Column(name = "CustomerName", nullable = false, length = 100)
    private String customerName;

    @Column(name = "PhoneNumber", nullable = false, length = 20, unique = true)
    private String phoneNumber;

    @Column(name = "Email", nullable = false, length = 100, unique = true)
    private String email;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TicketEntity> tickets;
}