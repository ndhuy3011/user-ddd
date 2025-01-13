package com.ndhuy.user.profiles.domain;

import java.util.UUID;

public record ProfileId(UUID id) {
    public ProfileId {
        if (id == null) {
            throw new IllegalArgumentException("ProfileId must not be null");
        }
    }

    /**
     * Generate a new ProfileId
     * @return ProfileId
     */
    public static ProfileId generate() {
        return new ProfileId(UUID.randomUUID());
    }

    /**
     * Create a ProfileId from a string
     * @param id
     * @return
     */
    public static ProfileId fromString(String id) {
        return new ProfileId(UUID.fromString(id));
    }

    @Override
    public String toString() {
        return id.toString();
    }
}
