package com.example.logitran.service;

import com.example.logitran.entity.Vehicle;

import java.util.List;

public interface VehicleService {

    public List<Vehicle> getVehicles();
    public Vehicle getVehicle(int vehicleId);
    public Vehicle saveOrUpadateVehicle(Vehicle vehicle);
    public String deleteVehicle(int vehicleId);
    public List<Vehicle> findVehicleByCompanyId(int companyId);
}
