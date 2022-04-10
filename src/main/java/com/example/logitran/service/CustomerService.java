package com.example.logitran.service;

import com.example.logitran.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers();
    public Customer getCustomer(int customerId);
    public Customer saveOrUpadateCustomer(Customer customer);
    public String deleteCustomer(int customerId);


}
