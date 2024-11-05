package com.example.bookingticket.model.entities;

public enum BusType {
    GIUONG_NAM("Giường nằm"),
    GHE_NGOI("Ghế ngồi");

    private String value;

    BusType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}