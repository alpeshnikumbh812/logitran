package com.example.logitran.controller;

import com.example.logitran.entity.Company;
import com.example.logitran.entity.Customer;
import com.example.logitran.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {


    @Autowired
    CompanyService companyService;

    @GetMapping("/getList")
    public List<Company> getCustomers(){

        return companyService.getCompanies();
    }

    @PostMapping("/save")
    public Company save(@RequestBody Company company){

        return companyService.saveOrUpadateCompany(company);
    }

    @PostMapping("/update")
    public Company update(@RequestBody Company company){

        return companyService.saveOrUpadateCompany(company);
    }

    @GetMapping("/getCompany/{companyId}")
    public Company getCompany(@PathVariable int companyId){

        return companyService.getCompany(companyId);
    }

    @GetMapping("/getCompanyInterStateOrNot/{isInterState}")
    public List<Company> getCompany(@PathVariable boolean isInterState){

        return companyService.getCompanyInterStateOrNot(isInterState);
    }

    @DeleteMapping("/delete/{companyId}")
    public String deleteCompany(@PathVariable int companyId){

        return companyService.deleteCompany(companyId);
    }
}
