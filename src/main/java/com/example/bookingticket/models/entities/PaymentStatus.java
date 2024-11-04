package com.example.bookingticket.models.entities;

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
        return this.status;
    }
}

