package com.example.bookingticket.Repository;

import com.example.bookingticket.models.entities.BusCompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusCompanyRepository extends JpaRepository<BusCompanyEntity, Integer> {
}
