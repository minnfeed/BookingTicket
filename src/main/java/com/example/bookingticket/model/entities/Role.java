package com.example.bookingticket.model.entities;

import lombok.Getter;

@Getter
public enum Role {
    Customer("Customer"),
    Admin("Admin");

    private final String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return roleName;
    }
}