package com.example.bookingticket.Service;

import com.example.bookingticket.Repository.*;
import com.example.bookingticket.model.entities.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BookingService {

    @Autowired
    private BusRepository busRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Transactional
    public String bookTicket(int tripId, String customerName, String phoneNumber, String email, String seatNumber, BigDecimal price) {
        // Kiểm tra chuyến đi
        TripEntity trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new IllegalArgumentException("Trip not found"));

        // Kiểm tra hoặc tạo mới khách hàng
        CustomerEntity customer = customerRepository.findByPhoneNumber(phoneNumber)
                .orElseGet(() -> {
                    // Tạo khách hàng mới nếu không tồn tại
                    CustomerEntity newCustomer = CustomerEntity.builder()
                            .customerName(customerName)
                            .phoneNumber(phoneNumber)
                            .email(email)
                            .build();
                    return customerRepository.save(newCustomer);
                });
        BusEntity tourbus = busRepository.findByBusId(trip.getBus().getBusId())
                .orElseThrow(() -> new IllegalArgumentException("Bus not available"));

        // Kiểm tra ghế ngồi
        SeatEntity seat = seatRepository.findBySeatNumber(seatNumber)
                .orElseThrow(() -> new IllegalArgumentException("Seat not available"));

        if (seat.getSeatStatus() != SeatStatus.AVAILABLE) {
            throw new IllegalArgumentException("Seat is already booked");
        }

        // Cập nhật trạng thái ghế
        seat.setSeatStatus(SeatStatus.BOOKED);
        seatRepository.save(seat);

        // Tạo vé mới
        TicketEntity ticket = TicketEntity.builder()
                .customer(customer)
                .trip(trip)
                .seat(seat)
                .price(price)
                .paymentStatus(PaymentStatus.PENDING)  // hoặc là đã thanh toán, tuỳ vào yêu cầu
                .build();

        ticketRepository.save(ticket);

        return "Ticket booked successfully!";
    }

}