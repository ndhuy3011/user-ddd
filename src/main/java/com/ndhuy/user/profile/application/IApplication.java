package com.ndhuy.user.profile.application;

import java.util.concurrent.CompletableFuture;

public interface IApplication <T>{
    public void execute(T entity) ;
    public CompletableFuture<Void> executeAsync(T profile) ;
}
