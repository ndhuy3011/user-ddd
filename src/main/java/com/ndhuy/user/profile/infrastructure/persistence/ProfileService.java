package com.ndhuy.user.profile.infrastructure.persistence;

import java.util.concurrent.CompletableFuture;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ndhuy.user.exceptions.BadRequestException;
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

    /**
     * @param SearchProfileCommand
     * @return Profile
     * @ndhuy3011 Search profile if id not null
     */
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

    /**
     * @param CreateUserProfileCommand
     * @return InfoUserCommand
     * @ndhuy3011 Create profile
     */
    @Override
    public InfoUserCommand creatProfile(CreateUserProfileCommand command) {
        var id = ProfileId.fromString(SecurityContextHolder.getContext().getAuthentication().getName());
        var profile = Profile.create(id, command.profile().name(), command.profile().avatar(),
                command.profile().email());
        var residence = Residence.create(id, command.residence().title(), command.residence().address());
        CompletableFuture.allOf(addProfile.executeAsync(profile), addResidence.executeAsync(residence)).join();
        return new InfoUserCommand(profile, residence);
    }

    /**
     * 
     * @param CreateProfileCommand
     * @return Profile
     * @ndhuy3011 Create profile
     */
    @Override
    @Transactional
    public Profile createProfile(CreateProfileCommand command) {
        var id = ProfileId.fromString(SecurityContextHolder.getContext().getAuthentication().getName());
        var profile = Profile.create(id, command.name(), command.avatar(), command.email());
        addProfile.execute(profile);
        return profile;
    }

    /**
     * 
     * @param String
     * @return Profile
     * @ndhuy3011 Search profile if id not null
     */
    public Profile searchProfile(String id) {
        return searchProflie.searchProfile(id);
    }

    /**
     * @param SearchProfileCommand
     * @return Profile
     * @ndhuy3011 Search profile if id, email, name is null
     */
    @Override
    @Transactional(readOnly = true)
    public Profile searchProfile(SearchProfileCommand command) {
        return searchProflie.searchProfile(
                command.id().toString(),
                command.email(),
                command.name());
    }

    /**
     * @param UpdateProfileCommand
     * @return Profile
     * @ndhuy3011 Update profile
     */
    @Override
    @Transactional
    public Profile updateProfile(UpdateProfileCommand command) {
        // validate Request is authorized to update
        var id = ProfileId.fromString(SecurityContextHolder.getContext().getAuthentication().getName());
        if (command.id().compareTo(id.id()) != 0) {
            throw new BadRequestException("ERR005");
        }

        var profileOld = searchProflie.searchProfile(command.id().toString());
        var profileNew = new Profile(profileOld);
        profileNew.update(command.name(), command.avatar(), command.email());
        updateProfile.execute(profileNew);

        return profileNew;
    }

}
