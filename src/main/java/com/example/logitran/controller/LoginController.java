package com.example.logitran.controller;

import com.example.logitran.Request.UserRequest;
import com.example.logitran.entity.Account;
import com.example.logitran.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    AccountService accountService;

    @PostMapping("/login-user")
    public Account login(@RequestBody UserRequest userRequest) {
        return accountService.getUserDetails(userRequest);
    }

    @GetMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public String login() {
        return "Hello world";
    }
}
