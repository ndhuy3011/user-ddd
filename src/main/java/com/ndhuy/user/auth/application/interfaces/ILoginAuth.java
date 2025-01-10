package com.ndhuy.user.auth.application.interfaces;

import com.ndhuy.user.auth.application.command.InfoUserCommand;

public interface ILoginAuth {
    public InfoUserCommand login(String username, String password) ;
}
