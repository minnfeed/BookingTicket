package com.example.bookingticket.Repository;

import com.example.bookingticket.model.entities.BusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BusRepository extends JpaRepository<BusEntity, Integer> {

    @Query("SELECT b FROM BusEntity b WHERE b.licensePlate = :licensePlate")
    Optional<BusEntity> findByLicensePlate(@Param("licensePlate") String licensePlate);

}