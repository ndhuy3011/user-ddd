package com.ndhuy.user.profile.infrastructure.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ndhuy.user.profile.application.IProfileService;
import com.ndhuy.user.profile.application.commands.CreateProfileCommand;
import com.ndhuy.user.profile.application.commands.SearchProfileCommand;
import com.ndhuy.user.profile.application.commands.UpdateProfileCommand;
import com.ndhuy.user.profile.domain.Profile;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Resource
    private IProfileService profileService;

    @PostMapping("/create")
    public ResponseEntity<Profile> postCreateProfile(@RequestBody CreateProfileCommand entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(profileService.createProfile(entity));
    }

    @PostMapping("/update")
    public ResponseEntity<Profile> postUpdateProfile(@RequestBody UpdateProfileCommand entity) {
        return ResponseEntity.ok(profileService.updateProfile(entity));
    }

    @PostMapping("/search")
    public ResponseEntity<Profile> postSearchProfile(@RequestBody SearchProfileCommand entity) {
        return ResponseEntity.ok(profileService.searchProfile(entity));
    }

    @PostMapping("/search/id")
    public ResponseEntity<Profile> postSearchIdProfile(@RequestBody SearchProfileCommand entity) {
        return ResponseEntity.ok(profileService.searchProfile(entity.id().toString()));
    }

}
