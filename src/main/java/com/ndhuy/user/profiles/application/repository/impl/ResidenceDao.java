package com.ndhuy.user.profiles.application.repository.impl;

import com.ndhuy.user.profiles.application.repository.IResidenceDao;
import com.ndhuy.user.profiles.domain.ProfileId;
import com.ndhuy.user.profiles.domain.Residence;
import com.ndhuy.user.profiles.domain.ResidenceRepository;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CompletableFuture;



@Transactional
@Component
@Slf4j
public class ResidenceDao implements IResidenceDao {
    @Resource
    private ResidenceRepository residenceRepository;
    /**
     * @param entity
     */
    @Override
    public void insertResidence(Residence entity) {
        residenceRepository.save(entity);
    }

    /**
     * @param residence
     * @return
     */
    @Override
    public CompletableFuture<Void> insertResidenceAsync(Residence residence) {
        return CompletableFuture.runAsync(() -> residenceRepository.save(residence));
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Residence searchResidence(String id) {
        return residenceRepository.findById(ProfileId.fromString(id)).orElseThrow();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public CompletableFuture<Residence> searchResidenceAsync(String id) {
        return CompletableFuture
                .supplyAsync(() -> residenceRepository.findById(ProfileId.fromString(id)).orElse(null));
    }
}
