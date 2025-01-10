package com.ndhuy.user.auth.application.interfaces;

import com.ndhuy.user.auth.application.command.CreateUserCommand;
import com.ndhuy.user.auth.application.command.InfoUserCommand;

public interface IRegisterAuth {
   InfoUserCommand register(CreateUserCommand command);
}
