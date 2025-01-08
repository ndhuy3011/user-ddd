package com.ndhuy.user.profile.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ndhuy.user.profile.domain.Profile;
import com.ndhuy.user.profile.domain.ProfileId;
import com.ndhuy.user.profile.domain.ProfileRepository;

import jakarta.annotation.Resource;


@Service
public class SearchProflie {
    @Resource
    ProfileRepository profileRepository;

    @Transactional(readOnly = true)
    public Profile searchProfile(String id, String email, String name) {
        return profileRepository.findBySearchProfifle(
                ProfileId.fromString(id),
                email,
                name).orElseThrow();

    }

    @Transactional(readOnly = true)
    public Profile searchProfile(String id) {
        return profileRepository.findById(ProfileId.fromString(id)).orElseThrow();
    }
}
