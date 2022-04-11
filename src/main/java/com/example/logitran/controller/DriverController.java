package com.example.logitran.controller;

import com.example.logitran.entity.Customer;
import com.example.logitran.entity.Driver;
import com.example.logitran.service.CustomerService;
import com.example.logitran.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    DriverService driverService;

    @GetMapping("/getList")
    public List<Driver> getDrivers(){

        return driverService.getDrivers();
    }

    @PostMapping("/saveOrUpdate")
    public Driver saveOrUpdate(@RequestBody Driver driver){

        return driverService.saveOrUpadateDriver(driver);
    }

    @GetMapping("/getDriver/{driverId}")
    public Driver getDriver(@PathVariable int driverId){

        return driverService.getDriver(driverId);
    }

    @GetMapping("/getDriverIsAvailable/{isAvailable}")
    public List<Driver> getDriver(@PathVariable boolean isAvailable){

        return driverService.isDriverAvailable(isAvailable);
    }

    @DeleteMapping("/delete/{driverId}")
    public String deleteDriver(@PathVariable int driverId){

        return driverService.deleteDriver(driverId);
    }
}
