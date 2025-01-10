package com.ndhuy.user.profile.application.commands;

public record CreateUserProfileCommand(CreateProfileCommand profile, CreateResidenceCommand residence) {
    
}
