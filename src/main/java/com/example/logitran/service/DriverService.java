package com.example.logitran.service;

import com.example.logitran.entity.Driver;

import java.util.List;

public interface DriverService {

    public List<Driver> getDrivers();
    public Driver getDriver(int driverId);
    public Driver saveOrUpadateDriver(Driver driver);
    public String deleteDriver(int driverId);
    public List<Driver> isDriverAvailable(boolean isAvailable);

    public void setDriverAvailability(int driverId);
}
