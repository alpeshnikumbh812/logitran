package com.example.logitran.controller;

import com.example.logitran.entity.Customer;
import com.example.logitran.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/getList")
    public List<Customer> getCustomers(){

        return customerService.getCustomers();
    }

    @PostMapping("/save")
    public Customer save(@RequestBody Customer customer){

        return customerService.saveOrUpadateCustomer(customer);
    }

    @PostMapping("/update")
    public Customer update(@RequestBody Customer customer){

        return customerService.saveOrUpadateCustomer(customer);
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
