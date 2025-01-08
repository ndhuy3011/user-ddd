package com.ndhuy.user.profile.application;

import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ndhuy.user.profile.domain.Residence;
import com.ndhuy.user.profile.domain.ResidenceRepository;

import jakarta.annotation.Resource;

@Service
public class AddResidence implements IApplication<Residence> {
    @Resource
    private ResidenceRepository residenceRepository;

    @Transactional
    public void execute(Residence entity) {
        residenceRepository.save(entity);
    }

    @Transactional
    public CompletableFuture<Void> executeAsync(Residence residence) {
        return CompletableFuture.runAsync(() -> residenceRepository.save(residence));
    }
}
