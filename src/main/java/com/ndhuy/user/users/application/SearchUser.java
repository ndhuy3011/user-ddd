package com.ndhuy.user.users.application;

import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.ndhuy.user.UserCase;
import com.ndhuy.user.exceptions.BadRequestException;
import com.ndhuy.user.users.domain.User;
import com.ndhuy.user.users.domain.UserNameId;
import com.ndhuy.user.users.domain.UserRepository;

import jakarta.annotation.Resource;

@UserCase
@Transactional(readOnly = true)
public class SearchUser {
    @Resource
    UserRepository userRepository;

    /**
     * 
     * @param username
     * @return boolean
     */
    public boolean usernameExistsById(String username) {
        return userRepository.existsById(UserNameId.generate(username));
    }

    /**
     * 
     * @param username
     * @return Username
     */
    public User getUsername(String username) {
        return userRepository.findById(UserNameId.generate(username))
                .orElseThrow(() -> new BadRequestException("ERR004"));
    }

    public User getUsername(UUID uuid) {
        return userRepository.findByUuid(uuid).orElseThrow(() -> new BadRequestException("ERR004"));
    }

}
