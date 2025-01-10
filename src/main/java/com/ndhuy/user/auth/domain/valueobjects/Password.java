package com.ndhuy.user.auth.domain.valueobjects;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.BCryptVersion;

public record Password(String value) {
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(BCryptVersion.$2Y);
    public Password {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Password is required");
        }
        if (value.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters");
        }

        if(encoder.upgradeEncoding(value)){
            value = encoder.encode(value);
        }
       

    }

    public static Password from(String value) {
        return new Password(value);
    }

    public boolean match(String rawPassword) {
        return encoder.matches(rawPassword, value);
    }

}
