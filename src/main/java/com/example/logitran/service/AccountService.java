package com.example.logitran.service;

import com.example.logitran.Request.UserRequest;
import com.example.logitran.entity.Account;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
    Account getUserDetails(UserRequest userRequest);
}
