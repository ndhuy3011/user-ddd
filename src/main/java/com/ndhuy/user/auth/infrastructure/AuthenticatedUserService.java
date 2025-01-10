package com.ndhuy.user.auth.infrastructure;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ndhuy.user.auth.application.AddUser;
import com.ndhuy.user.auth.application.SearchUser;
import com.ndhuy.user.auth.application.command.CreateUserCommand;
import com.ndhuy.user.auth.application.command.InfoUserCommand;
import com.ndhuy.user.auth.domain.Username;
import com.ndhuy.user.exceptions.BadRequestException;

import jakarta.annotation.Resource;

@Service
public class AuthenticatedUserService {
    @Resource
    AddUser addUser;
    @Resource
    SearchUser searchUser;

    @Transactional
    public InfoUserCommand register(CreateUserCommand command) {
        if (searchUser.usernameExistsById(command.username())) {
            throw new BadRequestException("ERR006");
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

    /**
     * @ndhuy3011
     *            Login function
     * @param username
     * @param password
     * @return InfoUserCommand
     */
    @Transactional
    public InfoUserCommand login(String username, String password) {
        var entity = searchUser.getUsername(username);
        if (entity == null) {
            throw new BadRequestException("ERR004");
        }
        if (!entity.getPassword().match(password)) {
            throw new BadRequestException("ERR004");
        }

        return new InfoUserCommand(entity.getUuid());
    }
}
