package com.ndhuy.user.profiles.application.interfaces;

import com.ndhuy.user.profiles.application.commands.UpdateProfileCommand;
import com.ndhuy.user.profiles.domain.Profile;

public interface IProfileService extends ISearchProfile, IAddProfile{


    Profile updateProfile(UpdateProfileCommand command);

}
