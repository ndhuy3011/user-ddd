package com.ndhuy.user.profiles.infrastructure.persistence;

import com.ndhuy.user.profiles.application.commands.*;
import com.ndhuy.user.profiles.domain.Profile;

public interface IProfileService {
    public InfoUserCommand getProfileInfo(String id);
    public InfoUserCommand creatProfile(CreateUserProfileCommand command);
    public Profile createProfile(CreateProfileCommand command);
    public Profile searchProfile(SearchProfileCommand command);
    public Profile updateProfile(UpdateProfileCommand command);
}
