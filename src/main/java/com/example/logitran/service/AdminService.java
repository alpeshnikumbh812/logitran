package com.example.logitran.service;

import com.example.logitran.entity.Admin;

public interface AdminService {

    public void addAdmin(Admin admin);

    public Admin getAdminByusername(String email);
}
