package com.example.logitran.dao;

import com.example.logitran.entity.Admin;

public interface AdminDAO {

    public void addAdmin(Admin admin);

    public Admin getAdminByusername(String email);
}
