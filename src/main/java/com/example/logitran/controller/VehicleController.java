package com.example.logitran.controller;

import com.example.logitran.Validation.Validation;
import com.example.logitran.entity.Company;
import com.example.logitran.entity.Customer;
import com.example.logitran.entity.Vehicle;
import com.example.logitran.service.CompanyService;
import com.example.logitran.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @Autowired
    Validation validation;

    @GetMapping("/getList")
    public List<Vehicle> getVehicles(){

        return vehicleService.getVehicles();
    }

    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> save(@RequestBody Vehicle vehicle){

        Map<String,Object> vehicleValidation = validation.vhicalValidation(vehicle);
        Map<String,Object> response = new HashMap<>();

        if(vehicleValidation.isEmpty()){
            Vehicle vehicle1 = vehicleService.saveOrUpadateVehicle(vehicle);
            response.put("Status","Success");
            response.put("Message","Entry Save Successfully");
        }
        else{
            response.put("Status","Fail");
            response.put("Message",vehicleValidation);
            return ResponseEntity.badRequest().body(vehicleValidation);
        }

        return ResponseEntity.accepted().body(response);
    }

    @PostMapping(value = "/update",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> update(@RequestBody Vehicle vehicle){

        Map<String,Object> vehicleValidation = validation.vhicalValidation(vehicle);
        Map<String,Object> response = new HashMap<>();

        if(vehicleValidation.isEmpty()){
            Vehicle vehicle1 = vehicleService.saveOrUpadateVehicle(vehicle);
            response.put("Status","Success");
            response.put("Message","Entry update Successfully");
        }
        else{
            response.put("Status","Fail");
            response.put("Message",vehicleValidation);
            return ResponseEntity.badRequest().body(vehicleValidation);
        }

        return ResponseEntity.accepted().body(response);
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
