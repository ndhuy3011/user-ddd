package com.ndhuy.user.profile.domain.valueobjects;

public record Name(String value) {
    public Name {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }
}
