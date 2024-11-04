package com.example.bookingticket;

import models.entities.BusCompanyEntity;
import models.entities.BusEntity;
import models.entities.BusType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BookingTicketApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

	@Test
	void contextLoads() {
	}
	@Test
	void testDatabaseConnection() {
		
		String sql = "SELECT 1";
		Integer result = jdbcTemplate.queryForObject(sql, Integer.class);
		Assertions.assertNotNull(result);
		assertEquals(1, result);
	}
	@Test
	void testToString() {
		// Tạo một đối tượng BusEntity với dữ liệu mẫu
		BusCompanyEntity busCompany = new BusCompanyEntity();
		busCompany.setBusCompanyID(6);
		busCompany.setBusCompanyName("Công ty Xe Khách");

		BusEntity bus = BusEntity.builder()
				.busID(6)
				.busCompany(busCompany)
				.licensePlate("29B-123.45")
				.seatCount(45)
				.busType(BusType.GIUONG_NAM) // Giả sử bạn đã định nghĩa BusType này
				.build();

		// Xác định giá trị mong đợi
		String expected = "{" +
				"Bus ID:6" +
				"\nBus Company ID:6" + // Giá trị của busCompany.getBusCompanyID()
				"\nLicense Plate:29B-123.45" +
				"\nSeat Count:45" +
				"\nBus Type:Giường nằm" + // Giá trị của bus.getBusType().toString()
				"}";

		// Kiểm tra xem kết quả từ toString() có bằng giá trị mong đợi không
		assertEquals(expected, bus.toString());
	}


}
