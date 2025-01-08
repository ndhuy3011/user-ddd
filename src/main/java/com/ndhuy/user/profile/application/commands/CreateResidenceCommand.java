package com.ndhuy.user.profile.application.commands;

import com.ndhuy.user.profile.domain.ProfileId;

public record CreateResidenceCommand( ProfileId id,String title,String address) {
    
}
