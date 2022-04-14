package com.example.logitran.daoimpl;

import com.example.logitran.dao.AdminDAO;
import com.example.logitran.entity.Admin;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class AdminDAOImpl implements AdminDAO {

    @Autowired
    EntityManager entityManager;


    @Override
    public void addAdmin(Admin admin) {
        Session session = entityManager.unwrap(Session.class);
        session.save(admin);
    }

    @Override
    public Admin getAdminByusername(String email) {

        Session session = entityManager.unwrap(Session.class);

        Query<Admin> query = session.createQuery("from Admin where email=:email",Admin.class);
        query.setParameter("email",email);
        try{
            Admin admin = query.getSingleResult();
            return admin;
        }
        catch (Exception e){
            return null;
        }
    }
}
