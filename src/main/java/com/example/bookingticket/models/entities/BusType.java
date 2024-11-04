package com.example.bookingticket.models.entities;

public enum BusType {
    GIUONG_NAM("Giường nằm"),
    GHE_NGOI("Ghế ngồi");

    private final String value;

    BusType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
