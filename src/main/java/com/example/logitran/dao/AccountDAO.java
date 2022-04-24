package com.example.logitran.dao;

import com.example.logitran.Request.UserRequest;
import com.example.logitran.entity.Account;
import com.example.logitran.entity.Customer;

import java.util.List;

public interface AccountDAO {

    public List<Account> getAccounts();

    public Account save(String username,String password,int roleId);

    public Account updateAccount(int accId,String username,String password);

    public void setIsActive(String username,boolean isActive);

    public int getAccountId(int accInd);

    public Account getAccount(UserRequest userRequest);

}
