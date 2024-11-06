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

import java.util.Optional;
import java.util.Random;

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
                .role(Role.Customer)  // Hoặc có thể là ADMIN tùy thuộc vào yêu cầ// Gán CustomerEntity cho UserAccountEntity
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
//    @Autowired
//    private EmailService emailService;
//
//    // Chức năng reset mật khẩu
//    public String resetPassword(String email) {
//        // Kiểm tra nếu email có tồn tại trong cơ sở dữ liệu
//        Optional<UserAccountEntity> userOptional = userAccountRepository.findByEmail(email);
//
//        if (!userOptional.isPresent()) {
//            return "Email không tồn tại!";
//        }
//
//        // Tạo mật khẩu ngẫu nhiên
//        String newPassword = generateRandomPassword();
//
//        UserAccountEntity user = userOptional.get();
//        user.setPassword(newPassword);  // Lưu mật khẩu không mã hóa trực tiếp vào database
//
//        // Lưu lại mật khẩu mới vào cơ sở dữ liệu
//        userAccountRepository.save(user);
//
//        // Gửi email với mật khẩu mới
//        emailService.sendEmail(user.getEmail(), "Mật khẩu mới của bạn", "Mật khẩu mới của bạn là: " + newPassword);
//
//        return "Mật khẩu mới đã được gửi tới email của bạn!";
//    }
//
//    // Hàm tạo mật khẩu ngẫu nhiên
//    private String generateRandomPassword() {
//        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
//        Random random = new Random();
//        StringBuilder password = new StringBuilder();
//
//        for (int i = 0; i < 8; i++) {
//            int index = random.nextInt(characters.length());
//            password.append(characters.charAt(index));
//        }
//
//        return password.toString();
//    }
}