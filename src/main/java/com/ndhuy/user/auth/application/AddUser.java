package com.ndhuy.user.auth.application;

import java.util.concurrent.CompletableFuture;

import org.springframework.transaction.annotation.Transactional;

import com.ndhuy.user.UserCase;
import com.ndhuy.user.auth.domain.User;
import com.ndhuy.user.auth.domain.UserRepository;
import com.ndhuy.user.interfaces.IApplication;

import jakarta.annotation.Resource;

@UserCase
@Transactional
public class AddUser implements IApplication<User> {

    @Resource UserRepository userRepository;


    /**
     * 
     * @param entity
     */
    @Override
    public void execute(User entity) {
        userRepository.save(entity);
    }

  
    /**
     * 
     * @param profile
     * @return
     */
    @Override
    public CompletableFuture<Void> executeAsync(User profile) {
        throw new UnsupportedOperationException("Unimplemented method 'executeAsync'");
    }
    
}
