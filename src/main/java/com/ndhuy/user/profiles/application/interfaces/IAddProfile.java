package com.ndhuy.user.profiles.application.interfaces;

import com.ndhuy.user.profiles.application.commands.CreateProfileCommand;
import com.ndhuy.user.profiles.application.commands.CreateUserProfileCommand;
import com.ndhuy.user.profiles.application.commands.InfoUserCommand;
import com.ndhuy.user.profiles.domain.Profile;

public interface IAddProfile {
     InfoUserCommand creatProfile(CreateUserProfileCommand command);
         Profile createProfile(CreateProfileCommand command);
}
