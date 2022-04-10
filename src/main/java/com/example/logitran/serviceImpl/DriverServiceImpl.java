package com.example.logitran.serviceImpl;

import com.example.logitran.dao.DriverDAO;
import com.example.logitran.dao.VehicleDAO;
import com.example.logitran.entity.Driver;
import com.example.logitran.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverDAO driverDAO;

    @Autowired
    VehicleDAO vehicleDAO;

    @Override
    @Transactional
    public List<Driver> getDrivers() {
        return driverDAO.getDrivers();
    }

    @Override
    @Transactional
    public Driver getDriver(int driverId) {
        return driverDAO.getDriver(driverId);
    }

    @Override
    @Transactional
    public Driver saveOrUpadateDriver(Driver driver) {

        return driverDAO.saveOrUpadateDriver(driver);
    }

    @Override
    @Transactional
    public String deleteDriver(int driverId) {

        String delete = driverDAO.deleteDriver(driverId);

        vehicleDAO.deleteByDriverId(driverId);

        return delete;

    }

    @Override
    public List<Driver> isDriverAvailable(boolean isAvailable) {
        return driverDAO.isAvailable(isAvailable);
    }
}
