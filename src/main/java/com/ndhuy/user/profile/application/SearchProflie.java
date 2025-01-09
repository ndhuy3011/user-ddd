package com.ndhuy.user.profile.application;

import java.util.concurrent.CompletableFuture;

import org.springframework.transaction.annotation.Transactional;

import com.ndhuy.user.UserCase;
import com.ndhuy.user.profile.domain.Profile;
import com.ndhuy.user.profile.domain.ProfileId;
import com.ndhuy.user.profile.domain.ProfileRepository;

import jakarta.annotation.Resource;

@UserCase
@Transactional(readOnly = true)
public class SearchProflie {
    @Resource
    ProfileRepository profileRepository;

 
    public Profile searchProfile(String id, String email, String name) {
        return profileRepository.findBySearchProfifle(
                ProfileId.fromString(id),
                email,
                name).orElseThrow();

    }

    public Profile searchProfile(String id) {
        return profileRepository.findById(ProfileId.fromString(id)).orElseThrow();
    }

    public CompletableFuture<Profile> searchProfileAsync(String id) {
        return CompletableFuture.supplyAsync(() -> profileRepository.findById(ProfileId.fromString(id)).orElseThrow());
    }
}
