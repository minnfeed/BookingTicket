package com.example.bookingticket.model.entities;

import lombok.Getter;

@Getter
public enum SeatStatus {
    AVAILABLE("Available"),
    BOOKED("Booked"),
    RESERVED("Reserved");

    private final String status;

    SeatStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }
}