package com.ndhuy.user.auth.domain.application;

import java.util.concurrent.CompletableFuture;

import org.springframework.transaction.annotation.Transactional;

import com.ndhuy.user.UserCase;
import com.ndhuy.user.auth.domain.Username;
import com.ndhuy.user.auth.domain.UsernameRepository;
import com.ndhuy.user.interfaces.IApplication;

import jakarta.annotation.Resource;

@UserCase
@Transactional
public class AddUser implements IApplication<Username> {

    @Resource UsernameRepository usernameRepository;

   
    public void execute(Username entity) {
        usernameRepository.save(entity);
    }

  
    public CompletableFuture<Void> executeAsync(Username profile) {
        throw new UnsupportedOperationException("Unimplemented method 'executeAsync'");
    }
    
}
