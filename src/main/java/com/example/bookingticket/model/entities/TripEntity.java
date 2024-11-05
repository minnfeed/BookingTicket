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
@Table(name = "Trip")
public class TripEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TripID")
    private Integer tripID;

    @ManyToOne
    @JoinColumn(name = "BusID", nullable = false)
    private BusEntity bus;

    @Column(name = "DepartureLocation", nullable = false, length = 100)
    private String departureLocation;

    @Column(name = "ArrivalLocation", nullable = false, length = 100)
    private String arrivalLocation;

    @Column(name = "DepartureTime", nullable = false)
    private LocalDateTime departureTime;

    @Column(name = "ArrivalTime", nullable = false)
    private LocalDateTime arrivalTime;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TicketEntity> tickets;
}
