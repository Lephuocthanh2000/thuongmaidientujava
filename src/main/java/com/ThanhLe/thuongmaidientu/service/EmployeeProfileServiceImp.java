package com.ThanhLe.thuongmaidientu.service;

import com.ThanhLe.thuongmaidientu.entity.EmployeeProfile;
import com.ThanhLe.thuongmaidientu.entity.User;
import com.ThanhLe.thuongmaidientu.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeProfileServiceImp implements EmployeeProfileService {
    @Autowired
    EmployeeRepository repository;
    List < EmployeeProfile > employeeProfileList = new ArrayList < > ();

//    @Override
//    public void addEmployeeProfile(EmployeeProfile profile) {
//        repository.save(profile);
//    }
//
//    @Override
//    public List < EmployeeProfile > getEmployeeProfiles() {
//        return repository.findAll();
//    }
//    @Override
//    public List<EmployeeProfile> getEmployeeProfilesName(String name){
//        return repository.findByName(name);
//    }

//    @Override
//    public Optional<EmployeeProfile> getEmployeeProfilesNameById (Integer id) {
//        return repository.findById(id);
//    }

    @Override
    public void addUser(EmployeeProfile user) {
        repository.save(user);
    }

    @Override
    public List<EmployeeProfile> getAllUser() {
        return repository.findAll();
    }
}
