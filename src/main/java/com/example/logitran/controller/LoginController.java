package com.example.logitran.controller;

import com.example.logitran.Request.UserRequest;
import com.example.logitran.entity.Account;
import com.example.logitran.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    AccountService accountService;

    @PostMapping(value = "/login-user",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String,Object>> login(@RequestBody UserRequest userRequest) {

        Map<String,Object> response = new HashMap<>();
        response.put("result",accountService.getUserDetails(userRequest));
        return ResponseEntity.accepted().body(response);
    }

    @GetMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public String login() {

        return "Hello world";
    }
}
