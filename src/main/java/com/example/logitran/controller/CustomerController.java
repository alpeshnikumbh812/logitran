package com.example.logitran.controller;

import com.example.logitran.Validation.Validation;
import com.example.logitran.entity.Customer;
import com.example.logitran.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    Validation validation;

    @GetMapping("/getList")
    public List<Customer> getCustomers(){

        return customerService.getCustomers();
    }

    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String,Object>> save(@RequestBody Customer customer){

        Map<String,Object> custValidation = validation.customerValidation(customer);
        Map<String,Object> response = new HashMap<>();

        if(custValidation.isEmpty()){
            Customer customer1 = customerService.saveOrUpadateCustomer(customer);
            response.put("Status","Success");
            response.put("Message","Entry Save Successfully");
        }
        else{
            response.put("Status","Fail");
            response.put("Message",custValidation);
            return ResponseEntity.badRequest().body(custValidation);
        }

         return ResponseEntity.accepted().body(response);
    }

    @PostMapping(value = "/update",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String,Object>> update(@RequestBody Customer customer){

        Map<String,Object> custValidation = validation.customerValidation(customer);
        Map<String,Object> response = new HashMap<>();
//        Customer customer1 = customerService.getCustomer(customer.getCustomerId());

        if(custValidation.isEmpty()){
            Customer customer1 = customerService.saveOrUpadateCustomer(customer);
            response.put("Status","Success");
            response.put("Message","Data updated Successfully");
            response.put("Customer",customer1);
        }
        else{
            response.put("Status","Fail");
            response.put("Message",custValidation);
            return ResponseEntity.badRequest().body(custValidation);
        }

        return ResponseEntity.accepted().body(response);
    }

    @GetMapping("/getCustomer/{customerId}")
    public Customer getCustomer(@PathVariable int customerId){

        return customerService.getCustomer(customerId);
    }

    @DeleteMapping("/delete/{customerId}")
    public String deleteCustomer(@PathVariable int customerId){

        return customerService.deleteCustomer(customerId);
    }
}
