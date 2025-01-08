package com.ndhuy.user.profile.infrastructure;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ndhuy.user.profile.application.AddProfile;
import com.ndhuy.user.profile.application.AddResidence;
import com.ndhuy.user.profile.application.IApplication;
import com.ndhuy.user.profile.application.IUserService;
import com.ndhuy.user.profile.application.commands.CreateUserCommand;
import com.ndhuy.user.profile.application.commands.InfoUserCommand;
import com.ndhuy.user.profile.domain.Profile;
import com.ndhuy.user.profile.domain.ProfileId;
import com.ndhuy.user.profile.domain.Residence;

@Service
public class UserService implements IUserService {
    private final IApplication<Residence> addResidence = new AddResidence();
    private final IApplication<Profile> addProfile = new AddProfile();

    @Override
    public InfoUserCommand getUserInfo(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'getUserInfo'");
    }

    @Transactional
    public InfoUserCommand creatUser(CreateUserCommand command) {
        var id = ProfileId.generate();
        
        var profile = Profile.create(id, command.profile().name(), command.profile().avatar(), command.profile().email());
        addProfile.execute(profile);

        var residence = Residence.create(id, command.residence().title(), command.residence().address());
        addResidence.execute(residence);
        
        return new InfoUserCommand(profile, residence);  
        
    }
    
}
