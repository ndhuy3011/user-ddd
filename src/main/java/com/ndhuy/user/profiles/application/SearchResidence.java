package com.ndhuy.user.profiles.application;

import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ndhuy.user.profiles.domain.ProfileId;
import com.ndhuy.user.profiles.domain.Residence;
import com.ndhuy.user.profiles.domain.ResidenceRepository;

import jakarta.annotation.Resource;


@Component
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
