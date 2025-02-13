package com.ndhuy.user.users.infrastructure.controller;

import com.ndhuy.user.users.application.command.VerifyUsernameAndPasswordCommand;
import com.ndhuy.user.users.infrastructure.services.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ndhuy.user.users.application.command.CreateUserCommand;
import com.ndhuy.user.users.application.command.InfoUserCommand;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    IUserService userService;

    @PostMapping("/verify")
    public ResponseEntity<InfoUserCommand> postLogin(@RequestBody VerifyUsernameAndPasswordCommand command) {
        return ResponseEntity.ok(userService.login(command.username(), command.password()));
    }

    @PostMapping("/create")
    public ResponseEntity<InfoUserCommand> postRegister(@RequestBody CreateUserCommand command) {
        return ResponseEntity.ok(userService.register(command));
    }

    @PostMapping("/info")
    public ResponseEntity<InfoUserCommand> postInfo(@RequestBody String username) {
        return ResponseEntity.ok(userService.getUserInfo(username));
    }
}
