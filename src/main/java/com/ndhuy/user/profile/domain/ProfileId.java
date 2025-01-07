package com.ndhuy.user.profile.domain;

import java.util.UUID;

public record ProfileId(UUID id) {
    public ProfileId {
        if (id == null) {
            throw new IllegalArgumentException("ProfileId must not be null");
        }
    }

    public static ProfileId generate() {
        return new ProfileId(UUID.randomUUID());
    }

    public static ProfileId fromString(String id) {
        return new ProfileId(UUID.fromString(id));
    }

    @Override
    public String toString() {
        return id.toString();
    }
}
