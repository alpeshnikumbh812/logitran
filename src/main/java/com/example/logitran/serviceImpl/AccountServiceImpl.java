package com.example.logitran.serviceImpl;

import com.example.logitran.Request.UserRequest;
import com.example.logitran.dao.AccountDAO;
import com.example.logitran.entity.Account;
import com.example.logitran.entity.Role;
import com.example.logitran.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDAO accountDAO;

    @Override
    public String getUserDetails(UserRequest userRequest) {

        Account account =  accountDAO.getAccount(userRequest);

        if(account!=null){
            String password = account.getPassword();
            Role role = account.getRole();
            String roleName = role.getName();
            return roleName;
        }
        else{
            return "User does not exist";
        }
    }
}
