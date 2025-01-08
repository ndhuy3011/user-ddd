package com.ndhuy.user.auth.domain;

import java.util.UUID;

public record UserNameId(UUID id, String username) {
    public UserNameId {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username is required");
        }
        if (username.length() < 6) {
            throw new IllegalArgumentException("Username must be at least 6 characters");
        }

        if (id == null) {
            throw new IllegalArgumentException("Id is required");
        }
    }

    public static UserNameId generate(String username) {
        return new UserNameId(UUID.randomUUID(), username);
    }

    public static UserNameId fromString(String id, String username) {
        return new UserNameId(UUID.fromString(id), username);
    }

    @Override
    public String toString() {
        return id.toString() + ", " + username;
    }
}
