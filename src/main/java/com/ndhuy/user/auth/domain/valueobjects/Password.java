package com.ndhuy.user.auth.domain.valueobjects;

public record Password(String value) {
    public Password {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Password is required");
        }
        if (value.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters");
        }
    }

}
