package com.ndhuy.user.profile.infrastructure.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ndhuy.user.profile.application.commands.CreateProfileCommand;
import com.ndhuy.user.profile.application.commands.CreateUserProfileCommand;
import com.ndhuy.user.profile.application.commands.InfoUserCommand;
import com.ndhuy.user.profile.application.commands.SearchProfileCommand;
import com.ndhuy.user.profile.application.commands.SearchUserCommand;
import com.ndhuy.user.profile.application.commands.UpdateProfileCommand;
import com.ndhuy.user.profile.application.interfaces.IProfileService;
import com.ndhuy.user.profile.domain.Profile;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Resource
    private IProfileService profile;

    @PostMapping("/create")
    public ResponseEntity<InfoUserCommand> postCreateUser(@RequestBody CreateUserProfileCommand command) {
        return ResponseEntity.status(201).body(profile.creatProfile(command));
    }

    @PostMapping("/info")
    public ResponseEntity<InfoUserCommand> postUserInfo(@RequestBody SearchUserCommand command) {
        return ResponseEntity.ok(profile.getProfileInfo(command.id()));
    }

    @PostMapping("/add")
    public ResponseEntity<Profile> postCreateProfile(@RequestBody CreateProfileCommand entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(profile.createProfile(entity));
    }

    @PostMapping("/update")
    public ResponseEntity<Profile> postUpdateProfile(@RequestBody UpdateProfileCommand entity) {
        return ResponseEntity.ok(profile.updateProfile(entity));
    }

    @PostMapping("/search")
    public ResponseEntity<Profile> postSearchProfile(@RequestBody SearchProfileCommand entity) {
        return ResponseEntity.ok(profile.searchProfile(entity));
    }

    @PostMapping("/search/id")
    public ResponseEntity<Profile> postSearchIdProfile(@RequestBody SearchProfileCommand entity) {
        return ResponseEntity.ok(profile.searchProfile(entity.id().toString()));
    }

}
