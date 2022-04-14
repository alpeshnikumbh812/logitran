package com.example.logitran.serviceImpl;

import com.example.logitran.dao.AdminDAO;
import com.example.logitran.entity.Admin;
import com.example.logitran.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminDAO adminDAO;

    @Transactional
    @Override
    public void addAdmin(Admin admin) {
        adminDAO.addAdmin(admin);
    }

    @Transactional
    @Override
    public Admin getAdminByusername(String email) {
        return adminDAO.getAdminByusername(email);
    }
}
