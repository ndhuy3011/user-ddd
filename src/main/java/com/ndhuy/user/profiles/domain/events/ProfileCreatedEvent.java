package com.ndhuy.user.profiles.domain.events;

import com.ndhuy.user.profiles.domain.Profile;

import lombok.Getter;

@Getter
public class ProfileCreatedEvent {
    private final Profile profile;

    public ProfileCreatedEvent( Profile profile) {
        this.profile = profile;
      
    }
    
}
