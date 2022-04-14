package com.example.logitran.controller;

import com.example.logitran.Validation.Validation;
import com.example.logitran.entity.Admin;
import com.example.logitran.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    Validation validation;

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String,Object>> addAdmin(@RequestBody Admin admin){

        Map<String,Object> adminValidation = validation.adminValidation(admin);
        Map<String,Object> response = new HashMap<>();

        if(adminValidation.isEmpty()){

           adminService.addAdmin(admin);
            response.put("Status","Success");
            response.put("Message","Entry Save Successfully");
        }
        else{
            response.put("Status","Fail");
            response.put("Message",adminValidation);
            return ResponseEntity.badRequest().body(adminValidation);
        }

        return ResponseEntity.accepted().body(response);
    }

    @PostMapping(value = "/getAdmin",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String,Object>> getAdmin(@RequestBody Admin admin){

        Map<String,Object> adminValidation = validation.adminValidation(admin);
        Map<String,Object> response = new HashMap<>();

        if(adminValidation.isEmpty()){

            Admin admin1 = adminService.getAdminByusername(admin.getEmail());
            response.put("Status","Success");
            response.put("Message","Entry Save Successfully");
            response.put("Admin",admin1);
        }
        else{
            response.put("Status","Fail");
            response.put("Message",adminValidation);
            return ResponseEntity.badRequest().body(adminValidation);
        }

        return ResponseEntity.accepted().body(response);
    }
}
