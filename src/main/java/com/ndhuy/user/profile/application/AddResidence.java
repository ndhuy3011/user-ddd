package com.ndhuy.user.profile.application;

import org.springframework.stereotype.Service;

import com.ndhuy.user.profile.domain.Residence;
import com.ndhuy.user.profile.domain.ResidenceRepository;

import jakarta.annotation.Resource;

@Service
public class AddResidence implements IApplication<Residence>{
    @Resource
    private ResidenceRepository residenceRepository;

    public void execute(Residence entity) {
        residenceRepository.save(entity);
    }
}
