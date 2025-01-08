package com.ndhuy.user.profile.application.commands;

import java.util.UUID;

public record SearchProfileCommand(UUID id,String name, String email) {  
    
}
