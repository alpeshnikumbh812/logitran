package com.example.logitran.daoimpl;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.logitran.dao.CompanyDAO;
import com.example.logitran.entity.Company;
import com.example.logitran.entity.Customer;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CompanyDAOImpl implements CompanyDAO {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Company> getCompanies() {
        Session session = entityManager.unwrap(Session.class);

        Query<Company> query = session.createQuery("from Company where is_delete=0", Company.class);
        List<Company> companies = query.getResultList();
        return companies;
    }

    @Override
    public Company getCompany(int companyId) {
        Session session = entityManager.unwrap(Session.class);

        Company company = session.get(Company.class, companyId);

        if(company.isDelete)
            return null;

        return company;
    }

    @Override
    public Company saveOrUpadateCompany(Company company) {
        Session session = entityManager.unwrap(Session.class);

        if (company.getCompanyId() == 0) {
            session.save(company);
        } else {
            try {
                Company company1 = session.get(Company.class,company.getCompanyId());
                company1.setAddress(company.getAddress());
                company1.setContactNo(company.getContactNo());
                company1.setEmail(company.getEmail());
                company1.setName(company.getName());
                company1.setAccId(company.getAccId());
                company1.setDelete(company.isDelete());
                company1.setInterState(company.isInterState());

                session.update(company1);
            } catch (Exception e) {

                throw new RuntimeException("No data exceed to update");
            }

        }

        return company;
    }

    @Override
    public String deleteCompany(int companyId) {

        Session session = entityManager.unwrap(Session.class);

        Company company = session.get(Company.class, companyId);
        company.setDelete(true);

        session.update(company);
        return "Successfully deleted";
    }

    @Override
    public List<Company> getCompanyInterState(boolean isInterState) {
        Session session = entityManager.unwrap(Session.class);

        Query<Company> query = session.createQuery("from Company where is_inter_state=:isInterState and is_delete=0",Company.class);
        query.setParameter("isInterState",isInterState);
        List<Company> companiesInterState = query.getResultList();

        return companiesInterState;
    }

    @Override
    public Company getCompanyByEmailId(String email) {

        Session session = entityManager.unwrap(Session.class);

        Query<Company> query = session.createQuery("from Company where email=:email",Company.class);

        query.setParameter("email",email);
        Company company = null;
        try {
            System.out.println("in try");
             company = query.getSingleResult();
        }catch (Exception e){
            return null;
        }

        return company;
    }
}