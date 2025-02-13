package com.ndhuy.user.users.infrastructure.services;

import com.ndhuy.user.users.application.interfaces.ILoginAuth;
import com.ndhuy.user.users.application.interfaces.IRegisterAuth;
import com.ndhuy.user.users.application.interfaces.ISearchAuth;

public interface IUserService extends ILoginAuth, ISearchAuth, IRegisterAuth {
    
}
