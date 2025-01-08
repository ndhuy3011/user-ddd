package com.ndhuy.user.profile.application;

import java.util.concurrent.CompletableFuture;

import org.springframework.transaction.annotation.Transactional;

import com.ndhuy.user.UserCase;
import com.ndhuy.user.profile.domain.Profile;
import com.ndhuy.user.profile.domain.ProfileRepository;

import jakarta.annotation.Resource;

@UserCase
public class UpdateProfile implements IApplication<Profile> {
    @Resource
    ProfileRepository profileRepository;

    @Transactional
    public void execute(Profile profile) {
        profileRepository.save(profile);
    }

    @Override
    public CompletableFuture<Void> executeAsync(Profile profile) {
        throw new UnsupportedOperationException("Unimplemented method 'executeAsync'");
    }
}
