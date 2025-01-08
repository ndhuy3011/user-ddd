package com.ndhuy.user.profile.application;

import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ndhuy.user.profile.domain.ProfileId;
import com.ndhuy.user.profile.domain.Residence;
import com.ndhuy.user.profile.domain.ResidenceRepository;

import jakarta.annotation.Resource;

@Service
public class SearchResidence {
    @Resource
    private ResidenceRepository residenceRepository;

    @Transactional(readOnly = true)
    public Residence searchResidence(String id) {
        return residenceRepository.findById(ProfileId.fromString(id)).orElseThrow();
    }

    @Transactional(readOnly = true)
    public CompletableFuture<Residence> searchResidenceAsync(String id) {
        return CompletableFuture
                .supplyAsync(() -> residenceRepository.findById(ProfileId.fromString(id)).orElse(null));
    }
}
