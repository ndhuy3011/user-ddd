package com.ndhuy.user.profiles.application.commands;

import java.util.UUID;

public record SearchProfileCommand(UUID id,String name, String email) {  
    
}
