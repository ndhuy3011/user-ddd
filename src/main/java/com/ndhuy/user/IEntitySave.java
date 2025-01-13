package com.ndhuy.user;

import java.util.concurrent.CompletableFuture;

public interface IEntitySave <T>{
    public void execute(T entity) ;
    public CompletableFuture<Void> executeAsync(T profile) ;
}
