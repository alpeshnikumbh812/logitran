package com.example.logitran.controller;

import com.example.logitran.Request.UserRequest;
import com.example.logitran.entity.Account;
import com.example.logitran.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    AccountService accountService;

    @PostMapping("/login-user")
    public Account login(@RequestBody UserRequest userRequest) {
        return accountService.getUserDetails(userRequest);
    }
}
