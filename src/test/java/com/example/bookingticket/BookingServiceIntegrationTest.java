package com.example.bookingticket;

import com.example.bookingticket.Repository.CustomerRepository;
import com.example.bookingticket.Repository.SeatRepository;
import com.example.bookingticket.Repository.TicketRepository;
import com.example.bookingticket.Repository.TripRepository;
import com.example.bookingticket.Service.BookingService;
import com.example.bookingticket.model.entities.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class BookingServiceIntegrationTest {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private TicketRepository ticketRepository;

    private CustomerEntity customer;
    private TripEntity trip;
    private SeatEntity seat;



    @Test
    public void testBookTicketWithRealDatabase() {
        // Đặt vé
        String bookedTicket = bookingService.bookTicket(1,"Lê Duy Khang","0358808913","lehoanggakhuong2006@gmail.com","A2", BigDecimal.valueOf(10000));
        System.out.println(bookedTicket);
    }
}
