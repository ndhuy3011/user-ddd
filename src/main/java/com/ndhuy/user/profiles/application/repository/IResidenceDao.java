package com.ndhuy.user.profiles.application.repository;

import com.ndhuy.user.profiles.domain.Residence;

import java.util.concurrent.CompletableFuture;

public interface IResidenceDao {
    public void insertResidence(Residence entity);
    public CompletableFuture<Void> insertResidenceAsync(Residence residence);
    public Residence searchResidence(String id);
    public CompletableFuture<Residence> searchResidenceAsync(String id);
}
