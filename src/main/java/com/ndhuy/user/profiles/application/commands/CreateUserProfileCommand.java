package com.ndhuy.user.profiles.application.commands;

public record CreateUserProfileCommand(CreateProfileCommand profile, CreateResidenceCommand residence) {
    
}
