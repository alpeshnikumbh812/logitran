package com.example.logitran.daoimpl;

import com.example.logitran.dao.AccountDAO;
import com.example.logitran.entity.Account;
import com.example.logitran.entity.Customer;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Account> getAccounts() {

        Session session = entityManager.unwrap(Session.class);
        Query<Account> query = session.createQuery("from Account", Account.class);

        List<Account> accounts = query.getResultList();

        return accounts;
    }

    @Override
    public Account save(String username, String password, int roleId) {

        Session session = entityManager.unwrap(Session.class);

        Account account = new Account(username, password, roleId);

        session.save(account);
        return account;
    }

    @Override
    public Account updateAccount(int accId, String username, String password) {

        Session session = entityManager.unwrap(Session.class);
        Account account = session.get(Account.class, accId);

        account.setPassword(password);
        account.setUsername(username);

        session.update(account);

        return account;
    }

    @Override
    public void setIsActive(String username, boolean isActive) {

        Session session = entityManager.unwrap(Session.class);

        Query query = session.createQuery("update Account set is_active=:isActive where username=:username");

        query.setParameter("isActive", isActive);
        query.setParameter("username", username);

        query.executeUpdate();
    }

    @Override
    public int getAccountId(int accId) {

        System.out.println("AccID" + accId);
        Session session = entityManager.unwrap(Session.class);
        Account account = session.get(Account.class, accId);
        System.out.println(account.getRoleId());
        return account.getRoleId();
    }

    @Override
    public Account getAccountByEmail(String email) {

        Session session = entityManager.unwrap(Session.class);

        Query<Account> query = session.createQuery("from Account where username=:email",Account.class);
        query.setParameter("email",email);
        Account account = null;

        try {
            account = query.getSingleResult();
        }
        catch (Exception e){
            return null;
        }

        return account;
    }

}
