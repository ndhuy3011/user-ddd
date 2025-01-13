package com.ndhuy.user.profiles.application;

import java.util.concurrent.CompletableFuture;

import org.springframework.transaction.annotation.Transactional;

import com.ndhuy.user.IEntitySave;
import com.ndhuy.user.UserCase;
import com.ndhuy.user.profiles.domain.Profile;
import com.ndhuy.user.profiles.domain.ProfileRepository;

import jakarta.annotation.Resource;

@UserCase
@Transactional
public class UpdateProfile implements IEntitySave<Profile> {
    @Resource
    ProfileRepository profileRepository;

    /**
     * @param Profile
     * @return void
     */

    @Override
    public void execute(Profile profile) {
        profileRepository.save(profile);
    }

    /**
     * @param Profile
     * @return CompletableFuture<Void>
     * 
     */
    @Override
    public CompletableFuture<Void> executeAsync(Profile profile) {
        return CompletableFuture.runAsync(() -> profileRepository.save(profile));
    }
}
