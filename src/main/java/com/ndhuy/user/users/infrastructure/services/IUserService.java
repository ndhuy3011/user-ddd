package com.ndhuy.user.users.infrastructure.services;

import com.ndhuy.user.users.application.interfaces.ICreateUser;
import com.ndhuy.user.users.application.interfaces.ISearchUsername;
import com.ndhuy.user.users.application.interfaces.IVerifyUsernameAndPassword;

public interface IUserService extends IVerifyUsernameAndPassword, ISearchUsername, ICreateUser {
    
}
