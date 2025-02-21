package com.ndhuy.user.profiles.application.commands;

import java.util.UUID;
import com.ndhuy.exceptions.BadRequestException;


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
