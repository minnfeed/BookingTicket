package com.example.bookingticket.models.entities;

public enum BusType {
    GIUONG_NAM("Giường nằm"), // Khớp với giá trị trong DB
    GHE_NGOI("Ghế ngồi"); // Khớp với giá trị trong DB

    private final String value;

    BusType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value; // Trả về giá trị tương ứng với tiếng Việt
    }
}
