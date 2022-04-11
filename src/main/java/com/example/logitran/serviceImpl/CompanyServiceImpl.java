package com.example.logitran.serviceImpl;

import com.example.logitran.dao.*;
import com.example.logitran.entity.Account;
import com.example.logitran.entity.Company;
import com.example.logitran.entity.Customer;
import com.example.logitran.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyDAO companyDAO;

    @Autowired
    DriverDAO driverDAO;

    @Autowired(required = true)
    VehicleDAO vehicleDAO;

    @Autowired
    AccountDAO accountDAO;

    @Autowired
    RoleDAO roleDAO;

    @Override
    @Transactional
    public List<Company> getCompanies() {
        return companyDAO.getCompanies();
    }

    @Override
    @Transactional
    public Company getCompany(int companyId) {
        return companyDAO.getCompany(companyId);
    }

    @Override
    @Transactional
    public Company saveOrUpadateCompany(Company company) {

        int roleId = roleDAO.getRoleId("Logistic Company");

        if(company.getCompanyId()==0){

            Account account = accountDAO.save(company.getEmail(),company.getPassword(),roleId);
            company.setAccId(account.getAccId());
        }
        else{
            Company company1 = companyDAO.getCompany(company.getCompanyId());
            int accId = company1.getAccId();
            company.setAccId(accId);
            accountDAO.updateAccount(accId,company.getEmail(),company.getPassword());
        }

        return companyDAO.saveOrUpadateCompany(company);
    }


    @Override
    @Transactional
    public String deleteCompany(int companyId) {

        String delete = companyDAO.deleteCompany(companyId);

        driverDAO.deleteByCompanyId(companyId);

        vehicleDAO.deleteVehicleOfDeletedDrivers(companyId);
        return delete;
    }

//    @Override
//    public List<Company> getCompanyInterStateOrNot(boolean isInterState) {
//        return companyDAO.getCompanyInterState(isInterState);
//    }
}
