package com.ndhuy.user.profile.domain.events;

import com.ndhuy.user.profile.domain.Profile;

import lombok.Getter;

@Getter
public class ProfileCreatedEvent {
    private final Profile profile;

    public ProfileCreatedEvent( Profile profile) {
        this.profile = profile;
      
    }
    
}
