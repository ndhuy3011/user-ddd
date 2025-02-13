package com.ndhuy.user.users.application.interfaces;

import com.ndhuy.user.users.application.command.CreateUserCommand;
import com.ndhuy.user.users.application.command.InfoUserCommand;

public interface ICreateUser {
   InfoUserCommand register(CreateUserCommand command);
}
