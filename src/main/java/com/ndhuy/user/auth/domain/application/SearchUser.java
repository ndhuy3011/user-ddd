package com.ndhuy.user.auth.domain.application;

import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.ndhuy.user.UserCase;
import com.ndhuy.user.auth.domain.UserNameId;
import com.ndhuy.user.auth.domain.Username;
import com.ndhuy.user.auth.domain.UsernameRepository;

import jakarta.annotation.Resource;

@UserCase
@Transactional(readOnly = true)
public class SearchUser {
    @Resource
    UsernameRepository usernameRepository;

    
    public boolean usernameExistsById(String username) {
        return usernameRepository.existsById(UserNameId.generate(username));
    }

    public Username getUsername(String username) {
        return usernameRepository.findById(UserNameId.generate(username)).orElseThrow();
    }
    public Username getUsername(UUID uuid) {
        return usernameRepository.findByUuid(uuid).orElseThrow();
    }

}
