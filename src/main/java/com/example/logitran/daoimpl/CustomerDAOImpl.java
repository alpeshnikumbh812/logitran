package com.example.logitran.daoimpl;

import com.example.logitran.dao.CustomerDAO;
import com.example.logitran.entity.Customer;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Customer> getCustomers() {

        Session session = entityManager.unwrap(Session.class);

        Query<Customer> query = session.createQuery("from Customer where is_delete=0", Customer.class);
        List<Customer> customers = query.getResultList();
        return customers;
    }

    @Override
    public Customer getCustomer(int customerId) {

        Session session = entityManager.unwrap(Session.class);

        Customer customer = session.get(Customer.class, customerId);

        if (customer.isDelete)
            return null;

        return customer;
    }

    @Override
    public Customer saveOrUpadateCustomer(Customer customer) {

        Session session = entityManager.unwrap(Session.class);


        if (customer.getCustomerId() == 0) {
            session.save(customer);
        } else {
            try {
                Customer customer1 = session.find(Customer.class, customer.getCustomerId());
                customer1.setName(customer.getName());
                customer1.setEmail(customer.getEmail());
                customer1.setContactNo(customer.getContactNo());
                customer1.setPassword(customer.getPassword());
                customer1.setAddress(customer.getAddress());

                session.update(customer1);
            } catch (Exception e) {

                throw new RuntimeException(e);
            }

        }

        return customer;
    }

    @Override
    public String deleteCustomer(int customerId) {

        Session session = entityManager.unwrap(Session.class);

        Customer customer = session.get(Customer.class, customerId);
        customer.setDelete(true);

        session.update(customer);
//        Query query = session.createQuery("delete from Customer where customer_id=:customerId");

//        query.setParameter("customerId",customerId);

//        query.executeUpdate();

        return "Successfully deleted";
    }

    @Override
    public Customer getCustomerByEmail(String email) {

        Session session = entityManager.unwrap(Session.class);

        System.out.println("in method");
        Query<Customer> query = session.createQuery("from Customer where email=:email", Customer.class);
        query.setParameter("email", email);

        Customer customer = null;
//        System.out.println(customer);
        try {
            System.out.println("in try");
            customer = query.getSingleResult();
        }catch (Exception e){
            return null;
        }

        return customer;
    }
}
