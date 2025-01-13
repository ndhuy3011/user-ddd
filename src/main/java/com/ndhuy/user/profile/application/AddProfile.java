package com.ndhuy.user.profile.application;

import java.util.concurrent.CompletableFuture;

import org.springframework.transaction.annotation.Transactional;

import com.ndhuy.user.UserCase;
import com.ndhuy.user.interfaces.IApplication;
import com.ndhuy.user.profile.domain.Profile;
import com.ndhuy.user.profile.domain.ProfileRepository;

import jakarta.annotation.Resource;

@UserCase
@Transactional
public class AddProfile implements IApplication<Profile> {
    @Resource
    ProfileRepository profileRepository;

    /**
     * @param Profile
     * @return void
     * @ndhuy3011 Add profile
     */
    @Override

    public void execute(Profile profile) {
        profileRepository.save(profile);
    }

    /**
     * @param Profile
     * @return CompletableFuture<Void>
     * @ndhuy3011 Add profile
     */

    @Override
    public CompletableFuture<Void> executeAsync(Profile profile) {
        return CompletableFuture.runAsync(() -> profileRepository.save(profile));
    }
}
