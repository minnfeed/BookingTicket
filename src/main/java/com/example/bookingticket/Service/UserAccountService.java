package com.example.bookingticket.Service;

import com.example.bookingticket.Repository.CustomerRepository;
import com.example.bookingticket.Service.Mappers.UserAccountMapper;
import com.example.bookingticket.model.dtos.Customer.CreateCustomerDTO;
import com.example.bookingticket.model.dtos.UserAccount.CreateUseAccountDTO;
import com.example.bookingticket.model.entities.CustomerEntity;
import com.example.bookingticket.model.entities.Role;
import com.example.bookingticket.model.entities.UserAccountEntity;
import com.example.bookingticket.Repository.UserAccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Transactional
    public String registerUser(CreateCustomerDTO createCustomerDTO, String password) {
        // Kiểm tra xem số điện thoại đã tồn tại chưa
        if (customerRepository.existsByPhoneNumber(createCustomerDTO.getPhoneNumber())) {
            throw new IllegalArgumentException("Phone number already exists.");
        }

        // Kiểm tra xem email đã tồn tại chưa
        if (customerRepository.existsByEmail(createCustomerDTO.getEmail())) {
            throw new IllegalArgumentException("Email already exists.");
        }

        // Tạo CustomerEntity từ DTO
        CustomerEntity customer = CustomerEntity.builder()
                .customerName(createCustomerDTO.getCustomerName())
                .phoneNumber(createCustomerDTO.getPhoneNumber())
                .email(createCustomerDTO.getEmail())
                .build();

        // Lưu CustomerEntity vào database
        customerRepository.save(customer);

        // Tạo UserAccountEntity và không mã hóa mật khẩu
        UserAccountEntity userAccount = UserAccountEntity.builder()
                .phoneNumber(createCustomerDTO.getPhoneNumber())
                .password(password)  // Lưu mật khẩu trực tiếp
                .role(Role.CUSTOMER)  // Hoặc có thể là ADMIN tùy thuộc vào yêu cầ// Gán CustomerEntity cho UserAccountEntity
                .build();

        // Lưu UserAccountEntity vào database
        userAccountRepository.save(userAccount);
        return "User registered successfully!";
    }
    public String loginUser(String phoneNumber, String password) {
        UserAccountEntity userAccountEntity = userAccountRepository.findByPhoneNumber(phoneNumber);

        if (userAccountEntity == null) {
            return "Phone number not found!";
        }

        // Kiểm tra mật khẩu (so sánh mật khẩu thuần túy)
        if (!userAccountEntity.getPassword().equals(password)) {
            return "Invalid password!";
        }

        return "Login successful!";
    }
}