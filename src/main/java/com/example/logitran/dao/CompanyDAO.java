package com.example.logitran.dao;

import com.example.logitran.entity.Company;
import com.example.logitran.entity.Customer;

import java.util.List;

public interface CompanyDAO {

    public List<Company> getCompanies();
    public Company getCompany(int companyId);
    public Company saveOrUpadateCompany(Company company);
    public String deleteCompany(int companyId);
//    public List<Company> getCompanyInterState(boolean isInterState);
    public Company getCompanyByEmailId(String email);

    Company getCustomerByContact(String contactNo);
}
