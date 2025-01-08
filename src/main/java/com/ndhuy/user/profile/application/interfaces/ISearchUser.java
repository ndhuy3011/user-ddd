package com.ndhuy.user.profile.application.interfaces;

import com.ndhuy.user.profile.application.commands.InfoUserCommand;

public interface ISearchUser {
    public InfoUserCommand getUserInfo(String id) ;
}
