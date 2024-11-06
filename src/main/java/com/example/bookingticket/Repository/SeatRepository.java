package com.example.bookingticket.Repository;

import com.example.bookingticket.model.entities.SeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeatRepository extends JpaRepository<SeatEntity, Integer> {
    Optional<SeatEntity> findBySeatNumber(String seatNumber);
    Optional<SeatEntity> findBySeatNumberAndBusId(String seatNumber, int busId);
    Optional<SeatEntity> findBySeatNumberAndBus_BusId(String seatNumber, int busId);
}