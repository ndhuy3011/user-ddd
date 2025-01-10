package com.ndhuy.user.profile.application.interfaces;

import com.ndhuy.user.profile.application.commands.InfoUserCommand;
import com.ndhuy.user.profile.application.commands.SearchProfileCommand;
import com.ndhuy.user.profile.domain.Profile;

public interface ISearchProfile {
    public InfoUserCommand getProfileInfo(String id);

    Profile searchProfile(SearchProfileCommand command);

    Profile searchProfile(String command);
}
