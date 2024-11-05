package com.example.bookingticket;

import com.example.bookingticket.Repository.BusRepository;
import com.example.bookingticket.model.entities.BusEntity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BusRepositoryTest {

    @Autowired
    private BusRepository busRepository;

    @Test
    public void testFindByLicensePlate() {
        String licensePlate = "29A-12345"; // Đảm bảo giá trị này tồn tại trong cơ sở dữ liệu
        Optional<BusEntity> bus = busRepository.findByLicensePlate(licensePlate);
        System.out.println("Result: " + bus.orElse(null)); // In ra kết quả truy vấn
        assertTrue(bus.isPresent(), "Expecting Optional to contain a value but it was empty.");
    }



    @Test
    public void testFindByNonExistentLicensePlate() {
        // Thử tìm xe buýt theo biển số không tồn tại
        Optional<BusEntity> foundBus = busRepository.findByLicensePlate("XX-XXXX");

        // Kiểm tra xem kết quả không có giá trị
        assertThat(foundBus).isNotPresent();
    }
}
