package com.ndhuy.user.profiles.infrastructure.persistence.impl;

import java.util.concurrent.CompletableFuture;

import com.ndhuy.aspect.UserCase;
import com.ndhuy.user.profiles.application.repository.IProfileDao;
import com.ndhuy.user.profiles.application.repository.IResidenceDao;
import com.ndhuy.user.profiles.infrastructure.persistence.IProfileService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;

import com.ndhuy.exceptions.BadRequestException;
import com.ndhuy.user.profiles.application.commands.CreateProfileCommand;
import com.ndhuy.user.profiles.application.commands.CreateUserProfileCommand;
import com.ndhuy.user.profiles.application.commands.InfoUserCommand;
import com.ndhuy.user.profiles.application.commands.SearchProfileCommand;
import com.ndhuy.user.profiles.application.commands.UpdateProfileCommand;
import com.ndhuy.user.profiles.domain.Profile;
import com.ndhuy.user.profiles.domain.ProfileId;
import com.ndhuy.user.profiles.domain.Residence;

import jakarta.annotation.Resource;

@UserCase
public class ProfileService implements IProfileService {
    @Resource
    private IProfileDao profileDao;
    @Resource
    private IResidenceDao residenceDao;



    /**
     * @return Profile
     * @ndhuy3011 Search profile if id not null
     */
    @Override
    @Transactional(readOnly = true)
    public InfoUserCommand getProfileInfo(String id) {

        return CompletableFuture.allOf(
                        profileDao.searchProfileAsync(id),
                        residenceDao.searchResidenceAsync(id)).thenApply(
                        ignored -> new InfoUserCommand(
                                profileDao.searchProfileAsync(id).join(),
                                residenceDao.searchResidenceAsync(id).join()))
                .join();
    }

    /**
     * @return InfoUserCommand
     * @ndhuy3011 Create profile
     */
    @Override
    public InfoUserCommand creatProfile(CreateUserProfileCommand command) {
        var id = ProfileId.fromString(SecurityContextHolder.getContext().getAuthentication().getName());
        var profile = Profile.create(id, command.profile().name(), command.profile().avatar(),
                command.profile().email());
        var residence = Residence.create(id, command.residence().title(), command.residence().address());
        CompletableFuture.allOf(profileDao.insertProfileAsync(profile), residenceDao.insertResidenceAsync(residence)).join();
        return new InfoUserCommand(profile, residence);
    }

    /**
     * 
     * @return Profile
     * @ndhuy3011 Create profile
     */
    @Override
    @Transactional
    public Profile createProfile(CreateProfileCommand command) {
        var id = ProfileId.fromString(SecurityContextHolder.getContext().getAuthentication().getName());
        var profile = Profile.create(id, command.name(), command.avatar(), command.email());
        profileDao.insertProfile(profile);
        return profile;
    }

    /**
     * 
     * @param id
     * @return Profile
     * @ndhuy3011 Search profile if id not null
     */
    public Profile searchProfile(String id) {
        return profileDao.searchProfile(id);
    }

    /**
     * @param command
     * @return Profile
     * @ndhuy3011 Search profile if id, email, name is null
     */
    @Override
    @Transactional(readOnly = true)
    public Profile searchProfile(SearchProfileCommand command) {
        return profileDao.searchProfile(
                command.id().toString(),
                command.email(),
                command.name());
    }

    /**
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

        var profileOld = profileDao.searchProfile(command.id().toString());
        var profileNew = new Profile(profileOld);
        profileNew.update(command.name(), command.avatar(), command.email());
        profileDao.updateProfile(profileNew);

        return profileNew;
    }

}
