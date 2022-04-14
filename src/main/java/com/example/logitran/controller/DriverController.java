package com.example.logitran.controller;

import com.example.logitran.Validation.Validation;
import com.example.logitran.entity.Customer;
import com.example.logitran.entity.Driver;
import com.example.logitran.service.CustomerService;
import com.example.logitran.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    DriverService driverService;

    @Autowired
    Validation validation;

    @GetMapping("/getList")
    public List<Driver> getDrivers(){

        return driverService.getDrivers();
    }

    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String,Object>> saveOrUpdate(@RequestBody Driver driver){

        Map<String,Object> driverValidation = validation.driverValidation(driver);
        Map<String,Object> response = new HashMap<>();

        if(driverValidation.isEmpty()){
            Driver driver1 = driverService.saveOrUpadateDriver(driver);
            response.put("Status","Success");
            response.put("Message","Entry Save Successfully");
        }
        else{
            response.put("Status","Fail");
            response.put("Message",driverValidation);
            return ResponseEntity.badRequest().body(response);
        }

        return ResponseEntity.accepted().body(response);
    }

    @PostMapping(value = "/update",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> update(@RequestBody Driver driver){
        Map<String,Object> driverValidation = validation.driverValidation(driver);
        Map<String,Object> response = new HashMap<>();

        if(driverValidation.isEmpty()){
            Driver driver1 = driverService.saveOrUpadateDriver(driver);
            response.put("Status","Success");
            response.put("Message","Entry update Successfully");
            response.put("Driver",driver1);
        }
        else{
            response.put("Status","Fail");
            response.put("Message",driverValidation);
            return ResponseEntity.badRequest().body(response);
        }

        return ResponseEntity.accepted().body(response);
    }

    @GetMapping("/getDriver/{driverId}")
    public Driver getDriver(@PathVariable int driverId){

        return driverService.getDriver(driverId);
    }

    @GetMapping("/getDriverIsAvailable/{isAvailable}")
    public List<Driver> isDriverAvailable(@PathVariable boolean isAvailable){

        return driverService.isDriverAvailable(isAvailable);
    }

    @PostMapping(value = "/setDriverAvailability",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public void setDriverAvailability(@RequestBody Driver driver){
        System.out.println(driver.getDriverId());
        driverService.setDriverAvailability(driver.getDriverId());
    }


    @DeleteMapping("/delete/{driverId}")
    public String deleteDriver(@PathVariable int driverId){

        return driverService.deleteDriver(driverId);
    }
}
