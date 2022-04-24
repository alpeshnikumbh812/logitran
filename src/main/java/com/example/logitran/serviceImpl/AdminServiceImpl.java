package com.example.logitran.serviceImpl;

import com.example.logitran.dao.AccountDAO;
import com.example.logitran.dao.AdminDAO;
import com.example.logitran.dao.RoleDAO;
import com.example.logitran.entity.Account;
import com.example.logitran.entity.Admin;
import com.example.logitran.entity.Company;
import com.example.logitran.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminDAO adminDAO;

    @Autowired
    RoleDAO roleDAO;

    @Autowired
    AccountDAO accountDAO;

    @Transactional
    @Override
    public void addAdmin(Admin admin) {


        int roleId = roleDAO.getRoleId("Admin");
        System.out.println(roleId);
        if(admin.getAdminId()==0){

            Account account = accountDAO.save(admin.getEmail(),admin.getPassword(),roleId);
            System.out.println(account);
            account.setAccId(account.getAccId());
        }

        adminDAO.addAdmin(admin);
    }

    @Transactional
    @Override
    public Admin getAdminByusername(String email) {
        return adminDAO.getAdminByusername(email);
    }
}
