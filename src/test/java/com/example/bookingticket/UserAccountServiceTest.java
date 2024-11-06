package com.example.bookingticket;

import com.example.bookingticket.Repository.CustomerRepository;
import com.example.bookingticket.Repository.UserAccountRepository;
import com.example.bookingticket.model.dtos.Customer.CreateCustomerDTO;
import com.example.bookingticket.model.dtos.UserAccount.CreateUseAccountDTO;
import com.example.bookingticket.model.entities.CustomerEntity;
import com.example.bookingticket.model.entities.Role;
import com.example.bookingticket.model.entities.UserAccountEntity;
import com.example.bookingticket.Service.UserAccountService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserAccountServiceTest {
    @Autowired
    private UserAccountRepository userAccountRepository;

    public void testPrintAllUserAccounts() {
        // Lấy tất cả các tài khoản người dùng từ cơ sở dữ liệu
        List<UserAccountEntity> userAccounts = userAccountRepository.findAll();

        // In ra thông tin của từng tài khoản người dùng
        if (userAccounts.isEmpty()) {
            System.out.println("No user accounts found.");
        } else {
            for (UserAccountEntity userAccount : userAccounts) {
                System.out.println("Phone Number: " + userAccount.getPhoneNumber());
                System.out.println("Password: " + userAccount.getPassword());
                System.out.println("Role: " + userAccount.getRole());
                System.out.println("----------------------------");
            }
        }
    }
    @Test
    public void runTest() {
        System.out.println("Testing: Print All User Accounts...");
        testPrintAllUserAccounts();
    }
}
