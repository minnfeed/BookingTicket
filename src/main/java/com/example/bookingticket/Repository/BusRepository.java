package com.example.bookingticket.Repository;

import com.example.bookingticket.models.entities.BusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface BusRepository extends JpaRepository<BusEntity, Integer> {
}
