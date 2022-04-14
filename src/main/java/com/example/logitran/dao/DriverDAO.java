package com.example.logitran.dao;

import com.example.logitran.entity.Company;
import com.example.logitran.entity.Driver;

import java.util.List;

public interface DriverDAO {

    public List<Driver> getDrivers();
    public Driver getDriver(int driverId);
    public Driver saveOrUpadateDriver(Driver driver);
    public String deleteDriver(int driverId);
    public void deleteByCompanyId(int companyId);
    public List<Driver> isAvailable(boolean isAvailable);
    public Driver getDriverByEmail(String email);

    public Driver getDriverByContactNo(String contact);

    public void setDriverAvailability(int driverId);
}
