package com.ndhuy.user.auth.domain.valueobjects;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.BCryptVersion;

public record Password(String value) {
    public Password {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Password is required");
        }
        if (value.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters");
        }

        value = new BCryptPasswordEncoder(BCryptVersion.$2Y).encode(value);

    }

    public static Password from(String value) {
        return new Password(value);
    }

    public boolean match(String rawPassword) {
        return new BCryptPasswordEncoder(BCryptVersion.$2Y).matches(rawPassword, value);
    }

}
