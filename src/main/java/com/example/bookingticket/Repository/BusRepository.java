package com.example.bookingticket.Repository;

import com.example.bookingticket.model.entities.TourbusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BusRepository extends JpaRepository<TourbusEntity, Integer> {

    @Query("SELECT b FROM TourbusEntity b WHERE b.licensePlate = :licensePlate")
    Optional<TourbusEntity> findByLicensePlate(@Param("licensePlate") String licensePlate);

}