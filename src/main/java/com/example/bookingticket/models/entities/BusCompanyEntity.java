package com.example.bookingticket.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "buscompany")
public class BusCompanyEntity {
    @Id
    @Column(name = "BusCompanyID", nullable = false)
    private Integer busCompanyID;

    @Column(name = "BusCompanyName", nullable = false, length = 100)
    private String  busCompanyName;

    @Column(name = "Address", nullable = false, length = 100)
    private String  address;

    @Column(name = "PhoneNumber", nullable = false, length = 20)
    private String  phoneNumber;

    @OneToMany(mappedBy = "busCompany", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BusEntity> buses;

}
