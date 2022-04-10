package com.example.logitran.daoimpl;

import com.example.logitran.dao.RoleDAO;
import com.example.logitran.entity.Account;
import com.example.logitran.entity.Role;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class RoleDAOImpl implements RoleDAO {

    @Autowired
    EntityManager entityManager;

    @Override
    public int getRoleId(String name) {
        Session session = entityManager.unwrap(Session.class);
        Query<Role> query = session.createQuery("from Role where name=:name", Role.class);
        query.setParameter("name", name);
        Role role = query.uniqueResult();
        return role.getRoleId();
    }

    @Override
    public String getRole(int roleId) {
        Session session = entityManager.unwrap(Session.class);
        Role role = session.get(Role.class, roleId);
        return role.getName();
    }
}
