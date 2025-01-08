package com.ndhuy.user.profile.application.interfaces;

import com.ndhuy.user.profile.application.commands.CreateUserCommand;
import com.ndhuy.user.profile.application.commands.InfoUserCommand;

public interface IAddUser {
     InfoUserCommand creatUser(CreateUserCommand command);
}
