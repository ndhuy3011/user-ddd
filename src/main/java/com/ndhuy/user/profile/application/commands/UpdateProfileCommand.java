package com.ndhuy.user.profile.application.commands;

import java.util.UUID;

public record UpdateProfileCommand(UUID id,String name, String email,String avatar) {
    public UpdateProfileCommand {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
    }
    
}
