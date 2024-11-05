package com.example.bookingticket.Repository;

import com.example.bookingticket.model.entities.TripEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<TripEntity, Integer> {

}