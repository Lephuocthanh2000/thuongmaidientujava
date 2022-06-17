package com.ThanhLe.thuongmaidientu.service;

import com.ThanhLe.thuongmaidientu.entity.EmployeeProfile;

import java.util.List;

public interface EmployeeProfileService {
//    void addEmployeeProfile(EmployeeProfile profile);
//    List< EmployeeProfile > getEmployeeProfiles();
//    List< EmployeeProfile > getEmployeeProfilesName (String name);
//
//    Optional<EmployeeProfile> getEmployeeProfilesNameById (Integer id);

    void addUser(EmployeeProfile user);

    List<EmployeeProfile> getAllUser();
}
