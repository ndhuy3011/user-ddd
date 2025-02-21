package com.ndhuy.user.profiles.application;

import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ndhuy.user.IEntitySave;
import com.ndhuy.user.profiles.domain.Residence;
import com.ndhuy.user.profiles.domain.ResidenceRepository;

import jakarta.annotation.Resource;


@Component
@Transactional
public class AddResidence implements IEntitySave<Residence> {
    @Resource
    private ResidenceRepository residenceRepository;

    /**
     * @ndhuy3011 Add residence
     */
    
    @Override
    public void execute(Residence entity) {
        residenceRepository.save(entity);
    }


    /**
     * @return CompletableFuture<Void>
     * @ndhuy3011 Add residence
     */

    @Override
    public CompletableFuture<Void> executeAsync(Residence residence) {
        return CompletableFuture.runAsync(() -> residenceRepository.save(residence));
    }
}
