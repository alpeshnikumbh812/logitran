package com.example.logitran.dao;

import com.example.logitran.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getCustomers();

    Customer getCustomer(int customerId);

    Customer saveOrUpadateCustomer(Customer customer);

    String deleteCustomer(int customerId);

    Customer getCustomerByEmail(String email);

    Customer getCustomerByContact(String contact);
}
