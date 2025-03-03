package com.ndhuy.user.profiles.application.repository;

import com.ndhuy.user.profiles.domain.Profile;

import java.util.concurrent.CompletableFuture;

public interface IProfileDao {
    public void insertProfile(Profile profile);
    public CompletableFuture<Void> insertProfileAsync(Profile profile);
    public void updateProfile(Profile profile);
    public CompletableFuture<Void> updateProfileAsync(Profile profile);
    public Profile searchProfile(String id, String email, String name);
    public Profile searchProfile(String id);
    public CompletableFuture<Profile> searchProfileAsync(String id);
}
