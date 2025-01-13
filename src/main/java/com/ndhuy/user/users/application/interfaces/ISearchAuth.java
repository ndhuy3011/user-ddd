package com.ndhuy.user.users.application.interfaces;

import com.ndhuy.user.users.application.command.InfoUserCommand;

public interface ISearchAuth {
    public InfoUserCommand getUserInfo(String username);
}
