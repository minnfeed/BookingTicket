package com.example.bookingticket.model.entities;

import lombok.Getter;

@Getter
public enum PaymentStatus {
    PAID("Paid"),
    PENDING("Pending"),
    CANCELLED("Cancelled");

    private final String status;

    PaymentStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }
}