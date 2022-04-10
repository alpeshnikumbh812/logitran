package com.example.logitran.service;

import com.example.logitran.entity.Company;
import com.example.logitran.entity.Customer;

import java.util.List;

public interface CompanyService {

    public List<Company> getCompanies();
    public Company getCompany(int companyId);
    public Company saveOrUpadateCompany(Company company);
    public String deleteCompany(int companyId);
    public List<Company> getCompanyInterStateOrNot(boolean isInterState);

}
