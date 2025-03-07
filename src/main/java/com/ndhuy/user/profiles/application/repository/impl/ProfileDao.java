package com.ndhuy.user.profiles.application.repository.impl;

import com.ndhuy.user.profiles.application.repository.IProfileDao;
import com.ndhuy.user.profiles.domain.Profile;
import com.ndhuy.user.profiles.domain.ProfileId;
import com.ndhuy.user.profiles.domain.ProfileRepository;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CompletableFuture;

@Transactional
@Component
@Slf4j
public class ProfileDao implements IProfileDao {
    @Resource
    ProfileRepository profileRepository;
    /**
     * @param profile
     */
    @Override
    public void insertProfile(Profile profile) {

            profileRepository.save(profile);

    }

    /**
     * @param profile
     * @return
     */
    @Override
    public CompletableFuture<Void> insertProfileAsync(Profile profile) {
        return CompletableFuture.runAsync(() -> profileRepository.save(profile));
    }

    /**
     * @param profile
     */
    @Override
    public void updateProfile(Profile profile) {
        profileRepository.save(profile);
    }

    /**
     * @param profile
     * @return
     */
    @Override
    public CompletableFuture<Void> updateProfileAsync(Profile profile) {
        return CompletableFuture.runAsync(() -> profileRepository.save(profile));
    }

    /**
     * @param id
     * @param email
     * @param name
     * @return
     */
    @Override
    public Profile searchProfile(String id, String email, String name) {
        return profileRepository.findBySearchProfifle(
                ProfileId.fromString(id),
                email,
                name).orElseThrow();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Profile searchProfile(String id) {
        return profileRepository.findById(ProfileId.fromString(id)).orElseThrow();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public CompletableFuture<Profile> searchProfileAsync(String id) {
        return CompletableFuture.supplyAsync(() -> profileRepository.findById(ProfileId.fromString(id)).orElseThrow());
    }
}
