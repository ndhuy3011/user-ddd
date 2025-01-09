package com.ndhuy.user.auth.infrastructure;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ndhuy.user.auth.domain.Username;
import com.ndhuy.user.auth.domain.application.AddUser;
import com.ndhuy.user.auth.domain.application.SearchUser;
import com.ndhuy.user.auth.domain.application.command.CreateUserCommand;
import com.ndhuy.user.auth.domain.application.command.InfoUserCommand;

import jakarta.annotation.Resource;

@Service
public class CreateUser {
    @Resource
    AddUser addUser;
    @Resource
    SearchUser searchUser;

    @Transactional
    public InfoUserCommand register(CreateUserCommand command) {
        if (searchUser.usernameExistsById(command.username())) {
            throw new RuntimeException("Username already exists");
        }
        var entity = Username.create(command.username(), command.password(), command.email(), null, command.phone(),
                null, command.fullName());
        addUser.execute(entity);
        return new InfoUserCommand(entity.getUuid());
    }
    @Transactional(readOnly = true)
    public InfoUserCommand getUserInfo(String username) {
        var entity = searchUser.getUsername(username);
        return new InfoUserCommand(entity.getUuid());
    }

    @Transactional
    public InfoUserCommand login(String username, String password) {
        var entity = searchUser.getUsername(username);

        if (!entity.getPassword().match(password)) {
            throw new RuntimeException("Password is incorrect");
        }

        return new InfoUserCommand(entity.getUuid());
    }
}
