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
@Table(name = "buscompany")
public class BusCompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "buscompanyid")
    private int busCompanyId;

    @Column(name = "buscompanyname", nullable = false)
    private String busCompanyName;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phonenumber", nullable = false, unique = true)
    private String phoneNumber;


}