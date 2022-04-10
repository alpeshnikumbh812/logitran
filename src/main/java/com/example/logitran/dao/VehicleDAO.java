package com.example.logitran.dao;

import com.example.logitran.entity.Company;
import com.example.logitran.entity.Vehicle;

import java.util.List;

public interface VehicleDAO {

    public List<Vehicle> getVehicles();
    public Vehicle getVehicle(int vehicleId);
    public Vehicle saveOrUpadateVehicle(Vehicle vehicle);
    public String deleteVehicle(int vehicleId);
    public void deleteByDriverId(int driverId);
    public void deleteVehicleOfDeletedDrivers(int companyId);
    public List<Vehicle> findVehicleByCompanyId(int companyId);

}
