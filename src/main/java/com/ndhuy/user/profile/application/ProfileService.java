package com.ndhuy.user.profile.application;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ndhuy.user.profile.application.commands.CreateProfileCommand;
import com.ndhuy.user.profile.application.commands.SearchProfileCommand;
import com.ndhuy.user.profile.domain.Profile;
import com.ndhuy.user.profile.domain.ProfileId;
import com.ndhuy.user.profile.domain.ProfileRepository;

import jakarta.annotation.Resource;

@Service
public class ProfileService {
    @Resource
    private  ProfileRepository profileRepository;


    @Transactional
    public Profile createProfile(CreateProfileCommand command) {
        var profile = Profile.create(command.name() , command.email());
        return profileRepository.save(profile);
    }
    @Transactional(readOnly = true)
    public Profile getProfile(SearchProfileCommand command) {
                return profileRepository.findBySearchProfifle(
              new ProfileId(command.id())   ,
                command.email(),
                command.name()
        ).orElseThrow(() -> new Ex("Profile not found"));
    }
}
