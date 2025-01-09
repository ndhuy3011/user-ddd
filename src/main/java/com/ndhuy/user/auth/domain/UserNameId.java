package com.ndhuy.user.auth.domain;

public record UserNameId(String username) {
    public UserNameId {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username is required");
        }
        if (username.length() < 6) {
            throw new IllegalArgumentException("Username must be at least 6 characters");
        }

    }

    public static UserNameId generate(String username) {
        return new UserNameId(username);
    }

}
