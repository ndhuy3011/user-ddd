package com.ndhuy.user.profile.application.commands;


public record CreateProfileCommand(String avatar,String name, String email) {
    public CreateProfileCommand {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
    }


}
