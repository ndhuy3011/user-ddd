package com.ndhuy.user.profile.application;

import org.springframework.stereotype.Service;

import com.ndhuy.user.profile.application.commands.CreateProfileCommand;
import com.ndhuy.user.profile.application.commands.SearchProfileCommand;
import com.ndhuy.user.profile.application.commands.UpdateProfileCommand;
import com.ndhuy.user.profile.domain.Profile;
import com.ndhuy.user.profile.domain.ProfileRepository;

import jakarta.annotation.Resource;

@Service
public class ProfileService  implements IProfileService {
    @Resource
    private ProfileRepository profileRepository;

   
    public Profile createProfile(CreateProfileCommand command) {
        var profile = Profile.create(command.name(), command.email());
        return profileRepository.save(profile);
    }

    public Profile searchProfile(SearchProfileCommand command) {
        return profileRepository.findBySearchProfifle(
                command.id(),
                command.email(),
                command.name()).orElseThrow();
    }
   
    public Profile updateProfile(UpdateProfileCommand command) {
        var profile = searchProfile(new SearchProfileCommand(command.id(), null, null));
        profile.update(command.name(), command.email());
        return profileRepository.save(profile);
    }
}
