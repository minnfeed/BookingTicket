package com.example.bookingticket.Repository;

import com.example.bookingticket.model.entities.CustomerEntity;
import com.example.bookingticket.model.entities.UserAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccountEntity, String> {
    UserAccountEntity findByPhoneNumber(String phoneNumber);
    UserAccountEntity findByEmail(String email);
}