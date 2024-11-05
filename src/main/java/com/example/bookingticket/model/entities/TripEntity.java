package com.example.bookingticket.model.entities;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "trip")
public class TripEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tripid")
    private int tripId;

    @ManyToOne
    @JoinColumn(name = "busid", nullable = false)
    private TourbusEntity bus;

    @Column(name = "departurelocation", nullable = false)
    private String departureLocation;

    @Column(name = "arrivallocation", nullable = false)
    private String arrivalLocation;

    @Column(name = "departuretime", nullable = false)
    private LocalDateTime departureTime;

    @Column(name = "arrivaltime", nullable = false)
    private LocalDateTime arrivalTime;

}
