package com.ndhuy.user.users.application.interfaces;

import com.ndhuy.user.users.application.command.InfoUserCommand;

public interface ILoginAuth {
    public InfoUserCommand login(String username, String password) ;
}
