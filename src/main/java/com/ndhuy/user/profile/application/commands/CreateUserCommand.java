package com.ndhuy.user.profile.application.commands;

public record CreateUserCommand(CreateProfileCommand profile, CreateResidenceCommand residence) {
    
}
