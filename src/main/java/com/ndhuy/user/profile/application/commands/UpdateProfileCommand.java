package com.ndhuy.user.profile.application.commands;

import java.util.UUID;

import com.ndhuy.user.exceptions.BadRequestException;

public record UpdateProfileCommand(UUID id,String name, String email,String avatar) {
    public UpdateProfileCommand {
        if (id == null) {
            throw new BadRequestException("ERR011");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new BadRequestException("ERR009");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new BadRequestException("ERR010");
        }
    }
    
}
