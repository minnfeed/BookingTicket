package models.entities;

public enum Role {
    CUSTOMER("Customer"),
    ADMIN("Admin");

    private final String role;

    Role(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return this.role;
    }
}
