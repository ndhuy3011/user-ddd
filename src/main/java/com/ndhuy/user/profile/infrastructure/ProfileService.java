package com.ndhuy.user.profile.infrastructure;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ndhuy.user.profile.application.AddProfile;
import com.ndhuy.user.profile.application.IProfileService;
import com.ndhuy.user.profile.application.SearchProflie;
import com.ndhuy.user.profile.application.UpdateProfile;
import com.ndhuy.user.profile.application.commands.CreateProfileCommand;
import com.ndhuy.user.profile.application.commands.SearchProfileCommand;
import com.ndhuy.user.profile.application.commands.UpdateProfileCommand;
import com.ndhuy.user.profile.domain.Profile;

import jakarta.annotation.Resource;

@Service
public class ProfileService implements IProfileService {
    @Resource
    private SearchProflie searchProflie;

    @Resource
    private AddProfile addProfile;

    @Resource
    private UpdateProfile updateProfile;

    @Transactional
    public Profile createProfile(CreateProfileCommand command) {
        var profile = Profile.create(command.name(), command.avatar(), command.email());
        addProfile.execute(profile);
        return profile;
    }

    @Transactional(readOnly = true)
    public Profile searchProfile(SearchProfileCommand command) {
        return searchProflie.searchProfile(
                command.id().toString(),
                command.email(),
                command.name());
    }

    @Transactional
    public Profile updateProfile(UpdateProfileCommand command) {
        var profileOld = searchProflie.searchProfile(command.id().toString());
        var profileNew = new Profile(profileOld);
        profileNew.update(command.name(), command.avatar(), command.email());
        updateProfile.execute(profileNew);

        return profileNew;
    }
}
