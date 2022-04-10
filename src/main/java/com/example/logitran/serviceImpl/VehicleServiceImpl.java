package com.example.logitran.serviceImpl;

import com.example.logitran.dao.VehicleDAO;
import com.example.logitran.entity.Vehicle;
import com.example.logitran.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleDAO vehicleDAO;

    @Override
    @Transactional
    public List<Vehicle> getVehicles() {
        return vehicleDAO.getVehicles();
    }

    @Override
    @Transactional
    public Vehicle getVehicle(int vehicleId) {
        return vehicleDAO.getVehicle(vehicleId);
    }

    @Override
    @Transactional
    public Vehicle saveOrUpadateVehicle(Vehicle vehicle) {
        return vehicleDAO.saveOrUpadateVehicle(vehicle);
    }

    @Override
    @Transactional
    public String deleteVehicle(int vehicleId) {
        return vehicleDAO.deleteVehicle(vehicleId);
    }

    @Override
    public List<Vehicle> findVehicleByCompanyId(int companyId) {
        return vehicleDAO.findVehicleByCompanyId(companyId);
    }
}
