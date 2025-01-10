package com.ndhuy.user.profile.application.interfaces;

import com.ndhuy.user.profile.application.commands.CreateProfileCommand;
import com.ndhuy.user.profile.application.commands.CreateUserCommand;
import com.ndhuy.user.profile.application.commands.InfoUserCommand;
import com.ndhuy.user.profile.domain.Profile;

public interface IAddProfile {
     InfoUserCommand creatProfile(CreateUserCommand command);
         Profile createProfile(CreateProfileCommand command);
}
