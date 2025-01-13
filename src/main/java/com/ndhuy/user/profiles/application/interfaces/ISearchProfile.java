package com.ndhuy.user.profiles.application.interfaces;

import com.ndhuy.user.profiles.application.commands.InfoUserCommand;
import com.ndhuy.user.profiles.application.commands.SearchProfileCommand;
import com.ndhuy.user.profiles.domain.Profile;

public interface ISearchProfile {
    public InfoUserCommand getProfileInfo(String id);

    Profile searchProfile(SearchProfileCommand command);

    Profile searchProfile(String command);
}
