package com.example.bookingticket.model.entities;

import lombok.Getter;

@Getter
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