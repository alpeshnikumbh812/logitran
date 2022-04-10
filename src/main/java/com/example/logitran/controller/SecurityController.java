package com.example.logitran.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class SecurityController {

    @GetMapping("/")
    public String helloWorld(){
        return "Hello World";
    }
}
