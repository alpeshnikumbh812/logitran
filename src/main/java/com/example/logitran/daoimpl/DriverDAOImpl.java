package com.example.logitran.daoimpl;

import com.example.logitran.dao.DriverDAO;
import com.example.logitran.entity.Driver;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class DriverDAOImpl implements DriverDAO {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Driver> getDrivers() {
        Session session = entityManager.unwrap(Session.class);

        Query<Driver> query = session.createQuery("from Driver where is_delete=0",Driver.class);
        List<Driver> drivers = query.getResultList();
        return drivers;
    }

    @Override
    public Driver getDriver(int driverId) {
        Session session = entityManager.unwrap(Session.class);

        Driver driver = session.get(Driver.class,driverId);

        if(driver.isDelete)
            return null;

        return driver;
    }

    @Override
    public Driver saveOrUpadateDriver(Driver driver) {
        Session session = entityManager.unwrap(Session.class);

        if(driver.getDriverId()==0){
            driver.setAvailable(true);
            session.save(driver);
        }
        else{
            try {

                Driver driver1 = session.get(Driver.class,driver.getDriverId());

                driver1.setContactNo(driver.getContactNo());
                driver1.setName(driver.getName());

                session.update(driver1);
            }
            catch (Exception e){

                throw new RuntimeException("No data exceed to update");
            }

        }

        return driver;
    }

    @Override
    public String deleteDriver(int driverId) {
        Session session = entityManager.unwrap(Session.class);

        Driver driver = session.get(Driver.class,driverId);
        driver.setDelete(true);
        session.update(driver);
        return "Successfully deleted";
    }

    @Override
    public void deleteByCompanyId(int companyId) {

        Session session = entityManager.unwrap(Session.class);

        Query query = session.createQuery("update Driver set is_delete=1 where company_id=:companyId");

        query.setParameter("companyId",companyId);
        query.executeUpdate();
    }

    @Override
    public List<Driver> isAvailable(boolean isAvailable) {

        Session session = entityManager.unwrap(Session.class);

        Query<Driver> query = session.createQuery("from Driver where is_available=:isAvailable and is_delete=0");
        query.setParameter("isAvailable",isAvailable);
        List<Driver> availableDrivers = query.getResultList();
        return availableDrivers;
    }

    @Override
    public Driver getDriverByEmail(String email) {
        Session session = entityManager.unwrap(Session.class);

        Query<Driver> query = session.createQuery("from Driver where email=:email and is_delete=0");
        query.setParameter("email",email);
        try{
            Driver driver = query.getSingleResult();
            return driver;
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public Driver getDriverByContactNo(String contact) {
        Session session = entityManager.unwrap(Session.class);

        Query<Driver> query = session.createQuery("from Driver where contact_no=:contact and is_delete=0");
        query.setParameter("contact",contact);
        try{
            Driver driver = query.getSingleResult();
            return driver;
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public void setDriverAvailability(int driverId) {
        Session session = entityManager.unwrap(Session.class);

        Query query = session.createQuery("update Driver set is_available=1 where driver_id=:driverId");

        query.setParameter("driverId",driverId);
        query.executeUpdate();

    }
}
