package com.example.bookingticket;

import com.example.bookingticket.Repository.BusCompanyRepository;
import com.example.bookingticket.Repository.BusRepository;
import com.example.bookingticket.models.entities.BusCompanyEntity;
import com.example.bookingticket.models.entities.BusEntity;
import com.example.bookingticket.models.entities.BusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookingTicketApplication {
	public static void main(String[] args) {
		SpringApplication.run(BookingTicketApplication.class, args);
	}

	@Autowired
	private BusRepository busRepository;

	@Autowired
	private BusCompanyRepository busCompanyRepository;

	// Phương thức CommandLineRunner để thực hiện mã sau khi ứng dụng khởi động
	@Bean
	CommandLineRunner run() {
		return args -> {
			// Tạo một BusCompanyEntity mới
			BusCompanyEntity busCompany = BusCompanyEntity.builder()
					.busCompanyName("Công ty Xe Khách ABC")
					.address("abc")
					.phoneNumber("0123456789")
					.build();

			// In ra thông tin busCompany trước khi lưu
			System.out.println("Bus Company Name: " + busCompany.getBusCompanyName());

			// Lưu BusCompanyEntity vào cơ sở dữ liệu và in ra thông báo
			try {
				busCompany = busCompanyRepository.save(busCompany);
				System.out.println("Saved Bus Company: " + busCompany.getBusCompanyName());
			} catch (Exception e) {
				e.printStackTrace(); // In ra lỗi nếu có
			}

			// Kiểm tra xem busCompany có được lưu thành công không
			if (busCompany != null) {
				// Tạo BusEntity
				BusEntity bus = BusEntity.builder()
						.busCompany(busCompany) // Liên kết với BusCompanyEntity
						.licensePlate("29A-12345") // Biển số xe
						.seatCount(34) // Số ghế
						.busType(BusType.GIUONG_NAM) // Loại xe
						.build();

				// Lưu BusEntity vào cơ sở dữ liệu và in ra thông báo
				try {
					bus = busRepository.save(bus);
					System.out.println("Saved Bus: " + bus.getLicensePlate());
				} catch (Exception e) {
					e.printStackTrace(); // In ra lỗi nếu có
				}
			} else {
				System.out.println("Bus Company could not be saved. Bus cannot be created.");
			}
		};
	}

}
