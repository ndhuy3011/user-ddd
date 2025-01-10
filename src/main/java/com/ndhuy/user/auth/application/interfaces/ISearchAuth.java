package com.ndhuy.user.auth.application.interfaces;

import com.ndhuy.user.auth.application.command.InfoUserCommand;

public interface ISearchAuth {
    public InfoUserCommand getUserInfo(String username);
}
