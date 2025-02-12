package com.ndhuy.user.users.application;

import java.util.concurrent.CompletableFuture;

import org.springframework.transaction.annotation.Transactional;

import com.ndhuy.user.IEntitySave;
import com.ndhuy.user.UserCase;
import com.ndhuy.user.users.domain.User;
import com.ndhuy.user.users.domain.UserRepository;

import jakarta.annotation.Resource;

@UserCase
@Transactional
public class AddUser implements IEntitySave<User> {

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
