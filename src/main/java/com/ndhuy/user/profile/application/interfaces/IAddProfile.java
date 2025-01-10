package com.ndhuy.user.profile.application.interfaces;

import com.ndhuy.user.profile.application.commands.CreateProfileCommand;
import com.ndhuy.user.profile.application.commands.CreateUserProfileCommand;
import com.ndhuy.user.profile.application.commands.InfoUserCommand;
import com.ndhuy.user.profile.domain.Profile;

public interface IAddProfile {
     InfoUserCommand creatProfile(CreateUserProfileCommand command);
         Profile createProfile(CreateProfileCommand command);
}
