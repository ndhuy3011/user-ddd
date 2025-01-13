package com.ndhuy.user.profile.application;

import java.util.concurrent.CompletableFuture;

import org.springframework.transaction.annotation.Transactional;

import com.ndhuy.user.UserCase;
import com.ndhuy.user.interfaces.IApplication;
import com.ndhuy.user.profile.domain.Residence;
import com.ndhuy.user.profile.domain.ResidenceRepository;

import jakarta.annotation.Resource;

@UserCase
@Transactional
public class AddResidence implements IApplication<Residence> {
    @Resource
    private ResidenceRepository residenceRepository;

    /**
     * @param Residence
     * @return void
     * @ndhuy3011 Add residence
     */
    
    @Override
    public void execute(Residence entity) {
        residenceRepository.save(entity);
    }


    /**
     * @param Residence
     * @return CompletableFuture<Void>
     * @ndhuy3011 Add residence
     */

    @Override
    public CompletableFuture<Void> executeAsync(Residence residence) {
        return CompletableFuture.runAsync(() -> residenceRepository.save(residence));
    }
}
