package com.ndhuy.user.profiles.application.commands;

import com.ndhuy.user.profiles.domain.Profile;
import com.ndhuy.user.profiles.domain.Residence;

public record InfoUserCommand(Profile profile, Residence residence) {
    
}
