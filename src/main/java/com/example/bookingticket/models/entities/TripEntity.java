package com.example.bookingticket.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "trip")
public class TripEntity {
    @Id
    @Column(name = "TripID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tripID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "BusID", referencedColumnName = "BusID", nullable = false)
    private BusEntity bus;

    @Column(name = "DepartureLocation", nullable = false, length = 100)
    private String departureLocation;

    @Column(name = "ArrivalLocation", nullable = false, length = 100)
    private String arrivalLocation;

    @Column(name = "DepartureTime", nullable = false)
    private LocalDateTime departureTime;

    @Column(name = "ArrivalTime", nullable = false)
    private LocalDateTime arrivalTime;

    @OneToMany(mappedBy = "trip")
    private List<TicketEntity> tickets;

    public Integer BusID() {
        return bus != null ? bus.getBusID() : null;
    }
}
