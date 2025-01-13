package com.ndhuy.user.profile.application;

import java.util.concurrent.CompletableFuture;

import org.springframework.transaction.annotation.Transactional;

import com.ndhuy.user.UserCase;
import com.ndhuy.user.profile.domain.ProfileId;
import com.ndhuy.user.profile.domain.Residence;
import com.ndhuy.user.profile.domain.ResidenceRepository;

import jakarta.annotation.Resource;

@UserCase

@Transactional(readOnly = true)
public class SearchResidence {
    @Resource
    private ResidenceRepository residenceRepository;

    /**
     * 
     * @param id
     * @return Residence
     */
    public Residence searchResidence(String id) {
        return residenceRepository.findById(ProfileId.fromString(id)).orElseThrow();
    }

    /**
     * 
     * @param id
     * @return CompletableFuture<Residence>
     */
    public CompletableFuture<Residence> searchResidenceAsync(String id) {
        return CompletableFuture
                .supplyAsync(() -> residenceRepository.findById(ProfileId.fromString(id)).orElse(null));
    }
}
