package com.ndhuy.user.profile.application.interfaces;

import com.ndhuy.user.profile.application.commands.CreateProfileCommand;
import com.ndhuy.user.profile.application.commands.SearchProfileCommand;
import com.ndhuy.user.profile.application.commands.UpdateProfileCommand;
import com.ndhuy.user.profile.domain.Profile;

public interface IProfileService {
    Profile createProfile(CreateProfileCommand command);
    Profile updateProfile(UpdateProfileCommand command);
    Profile searchProfile(SearchProfileCommand command);
    Profile searchProfile(String command);
}
