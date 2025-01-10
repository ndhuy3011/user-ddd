package com.ndhuy.user.profile.application.interfaces;

import com.ndhuy.user.profile.application.commands.UpdateProfileCommand;
import com.ndhuy.user.profile.domain.Profile;

public interface IProfileService extends ISearchProfile, IAddProfile{


    Profile updateProfile(UpdateProfileCommand command);

}
