package com.ndhuy.user.profile.infrastructure.persistence;

import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ndhuy.user.profile.application.AddProfile;
import com.ndhuy.user.profile.application.AddResidence;
import com.ndhuy.user.profile.application.SearchProflie;
import com.ndhuy.user.profile.application.SearchResidence;
import com.ndhuy.user.profile.application.UpdateProfile;
import com.ndhuy.user.profile.application.commands.CreateProfileCommand;
import com.ndhuy.user.profile.application.commands.CreateUserProfileCommand;
import com.ndhuy.user.profile.application.commands.InfoUserCommand;
import com.ndhuy.user.profile.application.commands.SearchProfileCommand;
import com.ndhuy.user.profile.application.commands.UpdateProfileCommand;
import com.ndhuy.user.profile.application.interfaces.IProfileService;
import com.ndhuy.user.profile.domain.Profile;
import com.ndhuy.user.profile.domain.ProfileId;
import com.ndhuy.user.profile.domain.Residence;

import jakarta.annotation.Resource;

@Service
public class ProfileService implements IProfileService {
    @Resource
    private SearchProflie searchProflie;

    @Resource
    private AddProfile addProfile;

    @Resource
    private UpdateProfile updateProfile;
    @Resource
    private AddResidence addResidence;

    @Resource
    private SearchResidence searchResidence;

    @Override
    @Transactional(readOnly = true)
    public InfoUserCommand getProfileInfo(String id) {

        return CompletableFuture.allOf(
                searchProflie.searchProfileAsync(id),
                searchResidence.searchResidenceAsync(id)).thenApply(
                        ignored -> new InfoUserCommand(
                                searchProflie.searchProfileAsync(id).join(),
                                searchResidence.searchResidenceAsync(id).join()))
                .join();
    }

    @Override
    public InfoUserCommand creatProfile(CreateUserProfileCommand command) {
        var id = ProfileId.generate();
        var profile = Profile.create(id, command.profile().name(), command.profile().avatar(),
                command.profile().email());
        var residence = Residence.create(id, command.residence().title(), command.residence().address());
        CompletableFuture.allOf(addProfile.executeAsync(profile), addResidence.executeAsync(residence)).join();
        return new InfoUserCommand(profile, residence);
    }

    @Override
    @Transactional
    public Profile createProfile(CreateProfileCommand command) {
        var profile = Profile.create(command.name(), command.avatar(), command.email());
        addProfile.execute(profile);
        return profile;
    }

    public Profile searchProfile(String id) {
        return searchProflie.searchProfile(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Profile searchProfile(SearchProfileCommand command) {
        return searchProflie.searchProfile(
                command.id().toString(),
                command.email(),
                command.name());
    }

    @Override
    @Transactional
    public Profile updateProfile(UpdateProfileCommand command) {
        var profileOld = searchProflie.searchProfile(command.id().toString());
        var profileNew = new Profile(profileOld);
        profileNew.update(command.name(), command.avatar(), command.email());
        updateProfile.execute(profileNew);

        return profileNew;
    }

}
