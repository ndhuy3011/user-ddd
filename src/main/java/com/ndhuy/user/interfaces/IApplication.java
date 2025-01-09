package com.ndhuy.user.interfaces;

import java.util.concurrent.CompletableFuture;

public interface IApplication <T>{
    public void execute(T entity) ;
    public CompletableFuture<Void> executeAsync(T profile) ;
}
