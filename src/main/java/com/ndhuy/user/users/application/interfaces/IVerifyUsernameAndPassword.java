package com.ndhuy.user.users.application.interfaces;

import com.ndhuy.user.users.application.command.InfoUserCommand;

public interface IVerifyUsernameAndPassword{
     InfoUserCommand login(String username, String password) ;
}
