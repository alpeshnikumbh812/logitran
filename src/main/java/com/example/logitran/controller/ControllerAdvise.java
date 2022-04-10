package com.example.logitran.controller;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ControllerAdvise {

    public ResponseEntity<String> notExceed(Exception e){

        return new ResponseEntity<String>((MultiValueMap<String, String>) e, HttpStatus.BAD_REQUEST);
    }
}
