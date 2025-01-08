package com.ndhuy.user.profile.application;

import com.ndhuy.user.profile.application.commands.CreateUserCommand;
import com.ndhuy.user.profile.application.commands.InfoUserCommand;

public interface IUserService {
    InfoUserCommand getUserInfo(String id);
    InfoUserCommand creatUser(CreateUserCommand command);
}
