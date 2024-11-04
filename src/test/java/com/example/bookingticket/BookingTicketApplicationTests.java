package com.example.bookingticket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

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
		Assertions.assertEquals(1, result);
	}

}
