package com.example.logitran.Validation;

import com.example.logitran.dao.CompanyDAO;
import com.example.logitran.dao.CustomerDAO;
import com.example.logitran.entity.Company;
import com.example.logitran.entity.Customer;
import com.example.logitran.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Component
@ControllerAdvice
public class Validation {

    @Autowired
    CustomerDAO customerDAO;

    @Autowired
    CompanyDAO companyDAO;

    private final String userExist = "Email already registered";
    private final String contactExist = "Contact number already registered";

    public Map<String,Object> customerValidation(Customer customer){

        Map<String,Object> messages = new HashMap<>();

        Customer customer1 = customerDAO.getCustomerByEmail(customer.getEmail());

        if(customer1!=null && customer.getCustomerId()==0){
            messages.put("Email",userExist);
        }

        customer1 = customerDAO.getCustomerByContact(customer.getContactNo());

        if(customer1!=null && customer.getCustomerId()!=customer1.getCustomerId() ){
            messages.put("Contact",contactExist);
        }

        return messages;
    }

    public Map<String,Object> companyValidation(Company company){

        Map<String,Object> messages = new HashMap<>();

        Company company1 = companyDAO.getCompanyByEmailId(company.getEmail());

        if(company1!=null && company.getCompanyId()==0){
            messages.put("Email",userExist);
        }

        company1 = companyDAO.getCustomerByContact(company.getContactNo());

        if(company1!=null && company.getCompanyId()!=company1.getCompanyId()){
            messages.put("Contact",contactExist);
        }

        return messages;
    }

    @ResponseBody
    @ExceptionHandler
    public Map<String,Object> customerValidation(Exception e){

        Map<String,Object> message = new HashMap<>();
        message.put("Contact",contactExist);
        return message;
    }
}
