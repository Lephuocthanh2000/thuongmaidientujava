package com.ThanhLe.thuongmaidientu.service;

import com.ThanhLe.thuongmaidientu.entity.EmployeeProfile;
import com.ThanhLe.thuongmaidientu.entity.User;

import java.util.List;
import java.util.Optional;

public interface EmployeeProfileService {
//    void addEmployeeProfile(EmployeeProfile profile);
//    List< EmployeeProfile > getEmployeeProfiles();
//    List< EmployeeProfile > getEmployeeProfilesName (String name);
//
//    Optional<EmployeeProfile> getEmployeeProfilesNameById (Integer id);

    void addUser(EmployeeProfile user);

    List<EmployeeProfile> getAllUser();
}
