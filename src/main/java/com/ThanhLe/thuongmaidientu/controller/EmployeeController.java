package com.ThanhLe.thuongmaidientu.controller;

import com.ThanhLe.thuongmaidientu.entity.EmployeeProfile;
import com.ThanhLe.thuongmaidientu.service.EmployeeProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employes")
public class EmployeeController {
    @Autowired
    EmployeeProfileService employeeProfileService;


    @PostMapping("/add")
    public String saveEmployeeProfile(@RequestBody EmployeeProfile user) {
        employeeProfileService.addUser(user);
        return "ok";
    }

    @GetMapping("/get")
    public ResponseEntity<List<EmployeeProfile>> getAllUser() {
        return new ResponseEntity<>(employeeProfileService.getAllUser(), HttpStatus.OK);
    }
}
