package com.ndhuy.user.auth.domain.valueobjects;

public record Phone(String phone) {
    public Phone {
        if (phone == null || phone.isBlank()) {
            throw new IllegalArgumentException("Phone must not be null or empty");
        }
    }

}
