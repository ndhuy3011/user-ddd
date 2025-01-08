package com.ndhuy.user.profile.infrastructure;

import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ndhuy.user.profile.application.AddProfile;
import com.ndhuy.user.profile.application.AddResidence;
import com.ndhuy.user.profile.application.commands.CreateUserCommand;
import com.ndhuy.user.profile.application.commands.InfoUserCommand;
import com.ndhuy.user.profile.application.interfaces.IAddUser;
import com.ndhuy.user.profile.application.interfaces.ISearchUser;
import com.ndhuy.user.profile.domain.Profile;
import com.ndhuy.user.profile.domain.ProfileId;
import com.ndhuy.user.profile.domain.Residence;

import jakarta.annotation.Resource;

@Service
public class UserService implements IAddUser,ISearchUser {

    @Resource
    private AddResidence addResidence;
    @Resource
    private AddProfile addProfile;

    @Override
    public InfoUserCommand getUserInfo(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'getUserInfo'");
    }

    @Transactional
    public InfoUserCommand creatUser(CreateUserCommand command) {
        var id = ProfileId.generate();
        var profile = Profile.create(id, command.profile().name(), command.profile().avatar(),
                command.profile().email());
        var residence = Residence.create(id, command.residence().title(), command.residence().address());
        CompletableFuture.allOf(addProfile.executeAsync(profile), addResidence.executeAsync(residence));
        return new InfoUserCommand(profile, residence);

    }

}