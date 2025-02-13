package com.ndhuy.user.users.infrastructure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ndhuy.user.users.application.command.CreateUserCommand;
import com.ndhuy.user.users.application.command.InfoUserCommand;
import com.ndhuy.user.users.application.command.LoginCommand;
import com.ndhuy.user.users.infrastructure.services.IAuthenService;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    IAuthenService authenService;

    @PostMapping("/login")
    public ResponseEntity<InfoUserCommand> postLogin(@RequestBody LoginCommand command) {
        return ResponseEntity.ok(authenService.login(command.username(), command.password()));
    }

    @PostMapping("/register")
    public ResponseEntity<InfoUserCommand> postRegister(@RequestBody CreateUserCommand command) {
        return ResponseEntity.ok(authenService.register(command));
    }

    @PostMapping("/info")
    public ResponseEntity<InfoUserCommand> postInfo(@RequestBody String username) {
        return ResponseEntity.ok(authenService.getUserInfo(username));
    }
}
