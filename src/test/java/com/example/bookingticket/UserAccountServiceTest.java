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
    private UserAccountService userAccountService;

    @Autowired
    private UserAccountRepository userAccountRepository;

    @BeforeEach
    public void setUp() {
        // Reset database or prepare mock data if needed
    }

    @Test
    public void testLoginUser_Success() {
        // Tạo dữ liệu người dùng
        String phoneNumber = "0901234567";
        String password = "01029321";
        UserAccountEntity userAccount = new UserAccountEntity();
        userAccount.setPhoneNumber(phoneNumber);
        userAccount.setPassword(password);
        userAccount.setRole(Role.Customer);

        // Lưu người dùng vào database (thực tế)
        userAccountRepository.save(userAccount);

        // Kiểm tra đăng nhập thành công
        String result = userAccountService.loginUser(phoneNumber, password);
        assertEquals("Login successful!", result);
    }

    @Test
    public void testLoginUser_PhoneNumberNotFound() {
        // Kiểm tra khi không có số điện thoại trong cơ sở dữ liệu
        String phoneNumber = "0901234567";
        String result = userAccountService.loginUser(phoneNumber, "password123");
        assertEquals("Phone number not found!", result);
    }

    @Test
    public void testLoginUser_InvalidPassword() {
        // Tạo dữ liệu người dùng
        String phoneNumber = "0901234567";
        String correctPassword = "password123";
        String wrongPassword = "wrongPassword";
        UserAccountEntity userAccount = new UserAccountEntity();
        userAccount.setPhoneNumber(phoneNumber);
        userAccount.setPassword(correctPassword);
        userAccount.setRole(Role.Customer);

        // Lưu người dùng vào database
        userAccountRepository.save(userAccount);

        // Kiểm tra khi mật khẩu không chính xác
        String result = userAccountService.loginUser(phoneNumber, wrongPassword);
        assertEquals("Invalid password!", result);
    }
}
