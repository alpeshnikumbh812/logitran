package com.example.logitran.serviceImpl;

import com.example.logitran.dao.AccountDAO;
import com.example.logitran.dao.CustomerDAO;
import com.example.logitran.dao.RoleDAO;
import com.example.logitran.entity.Account;
import com.example.logitran.entity.Customer;
import com.example.logitran.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDAO customerDAO;

    @Autowired
    AccountDAO accountDAO;

    @Autowired
    RoleDAO roleDAO;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public Customer getCustomer(int customerId) {
        return customerDAO.getCustomer(customerId);
    }

    @Override
    @Transactional
    public Customer     saveOrUpadateCustomer(Customer customer) {

        int roleId = roleDAO.getRoleId("Customer");
        System.out.println(roleId);
        if(customer.getCustomerId()==0){
            Account account = accountDAO.save(customer.getEmail(),customer.getPassword(),roleId);
            System.out.println(account + " " + customer.getPassword());
            customer.setAccId(account.getAccId());
        }
        else{
            Customer customer1 = customerDAO.getCustomer(customer.getCustomerId());
            System.out.println(customerDAO.getCustomer(customer.getCustomerId()).getAccId() + "Check");

            int accId = customer1.getAccId();
            customer.setAccId(accId);
            Account account = accountDAO.updateAccount(customerDAO.getCustomer(customer.getCustomerId()).getAccId(),customer.getEmail(),customer.getPassword());
            System.out.println(account);
        }

        return customerDAO.saveOrUpadateCustomer(customer);
    }

    @Override
    @Transactional
    public String deleteCustomer(int customerId) {

        Customer customer = customerDAO.getCustomer(customerId);

        accountDAO.setIsActive(customer.getEmail(),false);

        return customerDAO.deleteCustomer(customerId);
    }
}
