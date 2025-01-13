package com.ndhuy.user.profiles.application.commands;

import com.ndhuy.user.exceptions.BadRequestException;

public record CreateProfileCommand(String avatar,String name, String email) {
    public CreateProfileCommand {
        if (name == null || name.trim().isEmpty()) {
            throw new BadRequestException("ERR009");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new BadRequestException("ERR010");
        }
    
    }


}
