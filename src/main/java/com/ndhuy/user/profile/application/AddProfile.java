package com.ndhuy.user.profile.application;

import org.springframework.transaction.annotation.Transactional;

import com.ndhuy.user.UserCase;
import com.ndhuy.user.profile.domain.Profile;
import com.ndhuy.user.profile.domain.ProfileRepository;

import jakarta.annotation.Resource;

@UserCase
public class AddProfile {
    @Resource
    ProfileRepository profileRepository;

    @Transactional
    public void execute(Profile profile) {
        profileRepository.save(profile);
    }
}
