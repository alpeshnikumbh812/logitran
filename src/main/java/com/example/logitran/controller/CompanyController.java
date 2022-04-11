package com.example.logitran.controller;

import com.example.logitran.Validation.Validation;
import com.example.logitran.entity.Company;
import com.example.logitran.entity.Customer;
import com.example.logitran.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/company")
public class CompanyController {


    @Autowired
    CompanyService companyService;

    @Autowired
    Validation validation;

    //for customer use and admin
    @GetMapping("/getList")
    public List<Company> getCustomers(){

        return companyService.getCompanies();
    }

    //for company use and admin
    @PostMapping("/save")
    public Company save(@RequestBody Company company){

        return companyService.saveOrUpadateCompany(company);
    }

    //for company use and admin
    public ResponseEntity<Map<String,Object>> update(@RequestBody Company company){

        Map<String,Object> compValidation = validation.companyValidation(company);
        Map<String,Object> response = new HashMap<>();

        if(compValidation.isEmpty()){
            Company company1 = companyService.saveOrUpadateCompany(company);
            response.put("Status","Success");
            response.put("Message","Data updated Successfully");
            response.put("Company",company1);
        }
        else{
            response.put("Status","Fail");
            response.put("Message",compValidation);
            return ResponseEntity.badRequest().body(compValidation);
        }

        return ResponseEntity.accepted().body(response);
    }


    @GetMapping("/getCompany/{companyId}")
    public Company getCompany(@PathVariable int companyId){

        return companyService.getCompany(companyId);
    }


    @DeleteMapping("/delete/{companyId}")
    public String deleteCompany(@PathVariable int companyId){

        return companyService.deleteCompany(companyId);
    }
}
