package com.ndhuy.user.profiles.application;

import java.util.concurrent.CompletableFuture;

import org.springframework.transaction.annotation.Transactional;

import com.ndhuy.user.UserCase;
import com.ndhuy.user.profiles.domain.Profile;
import com.ndhuy.user.profiles.domain.ProfileId;
import com.ndhuy.user.profiles.domain.ProfileRepository;

import jakarta.annotation.Resource;

@UserCase
@Transactional(readOnly = true)
public class SearchProflie {
    @Resource
    ProfileRepository profileRepository;

    /**
     * 
     * @param id
     * @param email
     * @param name
     * @return Profile
     */
    public Profile searchProfile(String id, String email, String name) {
        return profileRepository.findBySearchProfifle(
                ProfileId.fromString(id),
                email,
                name).orElseThrow();

    }

    /**
     * 
     * @param id
     * @return Profile
     */
    public Profile searchProfile(String id) {
        return profileRepository.findById(ProfileId.fromString(id)).orElseThrow();
    }

    /**
     * 
     * @param id
     * @return CompletableFuture<Profile>
     */
    public CompletableFuture<Profile> searchProfileAsync(String id) {
        return CompletableFuture.supplyAsync(() -> profileRepository.findById(ProfileId.fromString(id)).orElseThrow());
    }
}
