package com.example.logitran.controller;

import com.example.logitran.entity.Company;
import com.example.logitran.entity.Vehicle;
import com.example.logitran.service.CompanyService;
import com.example.logitran.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @GetMapping("/getList")
    public List<Vehicle> getVehicles(){

        return vehicleService.getVehicles();
    }

    @PostMapping("/saveOrUpdate")
    public Vehicle saveOrUpdate(@RequestBody Vehicle vehicle){

        return vehicleService.saveOrUpadateVehicle(vehicle);
    }

    @GetMapping("/getVehicle/{vehicleNo}")
    public Vehicle getVehicle(@PathVariable int vehicleNo){

        return vehicleService.getVehicle(vehicleNo);
    }

    @GetMapping("/getVehicleByCompanyId/{companyId}")
    public List<Vehicle> getVehicleByCompanyId(@PathVariable int companyId){

        return vehicleService.findVehicleByCompanyId(companyId);
    }

    @DeleteMapping("/delete/{vehicleId}")
    public String deleteVehicle(@PathVariable int vehicleId){

        return vehicleService.deleteVehicle(vehicleId);
    }
}