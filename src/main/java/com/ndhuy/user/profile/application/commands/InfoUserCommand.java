package com.ndhuy.user.profile.application.commands;

import com.ndhuy.user.profile.domain.Profile;
import com.ndhuy.user.profile.domain.Residence;

public record InfoUserCommand(Profile profile, Residence residence) {
    
}
