package com.example.bookingticket;

import com.example.bookingticket.Repository.BusCompanyRepository;
import com.example.bookingticket.Repository.BusRepository;
import com.example.bookingticket.Repository.CustomerRepository;
import com.example.bookingticket.Repository.UserAccountRepository;
import com.example.bookingticket.models.entities.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@SpringJUnitWebConfig
public class BusRepositoryTest {

    @Autowired
    private BusRepository busRepository;
    @Autowired
    private BusCompanyRepository busCompanyRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private UserAccountRepository accountRepository;
    @Test
    @Transactional
    public void testViewBusData() {
        // Lấy tất cả dữ liệu từ bảng Bus
        List<BusEntity> busList = busRepository.findAll();

        // Kiểm tra rằng danh sách không rỗng
        assertFalse(busList.isEmpty(), "Bảng Bus không nên trống");

        // In ra dữ liệu để xem
        busList.forEach(bus -> {
            System.out.println("-------------");
            System.out.println("Bus ID: " + bus.getBusID());
            // Nếu bạn muốn in BusCompanyID, bạn cần gọi phương thức tương ứng
            System.out.println("Bus Company ID: " + (bus.getBusCompany() != null ? bus.getBusCompany().getBusCompanyID() : "Không có công ty"));
            System.out.println("License Plate: " + bus.getLicensePlate());
            System.out.println("Seat Count: " + bus.getSeatCount());
            System.out.println("Bus Type: " + bus.getBusType());
            System.out.println("-------------");
        });
    }

    @Test
    @Transactional
    public void createBusEntity() {
        BusCompanyEntity busCompany = new BusCompanyEntity();
        busCompany.setBusCompanyName("Company Name");
        busCompany.setAddress("Company Address");
        busCompany.setPhoneNumber("123456789");
        busCompanyRepository.save(busCompany); // Persist BusCompanyEntity first

        BusEntity bus = new BusEntity();
        bus.setLicensePlate("29A-12345");
        bus.setSeatCount(34);
        bus.setBusType(BusType.GIUONG_NAM); // assuming there's an enum BusType
        bus.setBusCompany(busCompany); // Set the busCompany reference
        busRepository.save(bus); // Now save the BusEntity


        // Kiểm tra lại xem BusEntity đã được lưu thành công chưa
        List<BusEntity> busList = busRepository.findAll();
        assertFalse(busList.isEmpty(), "Bảng Bus không nên trống");
    }
    @Test
    @Transactional
    public void createCustomerEntity() {
        // Tạo tài khoản người dùng trước
        UserAccountEntity userAccount = new UserAccountEntity();
        userAccount.setPhoneNumber("123456789");
        userAccount.setPassword("securepassword"); // Thay đổi mật khẩu theo nhu cầu của bạn
        accountRepository.save(userAccount); // Lưu tài khoản người dùng

        // Sau đó, tạo khách hàng
        CustomerEntity customer = new CustomerEntity();
        customer.setCustomerName("Customer Name");
        customer.setEmail("customer@example.com");
        customer.setPhoneNumber(userAccount.getPhoneNumber()); // Sử dụng số điện thoại từ tài khoản người dùng
        customerRepository.save(customer); // Lưu khách hàng

        // Kiểm tra lại xem khách hàng đã được lưu thành công chưa
        List<CustomerEntity> customerList = customerRepository.findAll();
        assertFalse(customerList.isEmpty(), "Bảng Customer không nên trống");
    }

}
