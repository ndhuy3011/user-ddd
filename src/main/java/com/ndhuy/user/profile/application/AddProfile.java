package com.ndhuy.user.profile.application;

import java.util.concurrent.CompletableFuture;

import org.springframework.transaction.annotation.Transactional;

import com.ndhuy.user.UserCase;
import com.ndhuy.user.profile.application.interfaces.IApplication;
import com.ndhuy.user.profile.domain.Profile;
import com.ndhuy.user.profile.domain.ProfileRepository;

import jakarta.annotation.Resource;

@UserCase
public class AddProfile implements IApplication<Profile> {
    @Resource
    ProfileRepository profileRepository;

    @Transactional
    public void execute(Profile profile) {
        profileRepository.save(profile);
    }
    @Transactional
    public CompletableFuture<Void> executeAsync(Profile profile) {
        return CompletableFuture.runAsync(() -> profileRepository.save(profile));
    }
}
