package com.example.bookingticket.Repository;

import com.example.bookingticket.model.entities.BusCompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BusCompanyRepository extends JpaRepository<BusCompanyEntity, Integer> {
    Optional<BusCompanyEntity> findByPhoneNumber(String phoneNumber);
}