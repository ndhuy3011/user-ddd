package com.ndhuy.user.profile.infrastructure.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ndhuy.user.profile.application.commands.CreateUserCommand;
import com.ndhuy.user.profile.application.commands.InfoUserCommand;
import com.ndhuy.user.profile.application.interfaces.IAddUser;

import jakarta.annotation.Resource;


@RestController
@RequestMapping("/user")
public class UserController {
    @Resource IAddUser addUser;


    @PostMapping("/create")
    public ResponseEntity<InfoUserCommand> postCreateUser(@RequestBody CreateUserCommand command) {
        return ResponseEntity.status(201).body(addUser.creatUser(command)) ;
    }
    
}
