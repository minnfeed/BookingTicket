package com.example.bookingticket;

import com.example.bookingticket.Repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // Đảm bảo sử dụng cơ sở dữ liệu thật
class BookingTicketApplicationTests {

	@Autowired
	private BusRepository busRepository; // Tiêm BusRepository vào lớp kiểm tra

//	@Test
//	public void testFindAll() {
//		List<BusRespondDTO> result = thanhvienService.findAll();
//		System.out.println(appUtil.toJson(result));
//	}
//}
}