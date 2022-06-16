package com.ThanhLe.thuongmaidientu.repository;


import com.ThanhLe.thuongmaidientu.entity.EmployeeProfile;
import com.ThanhLe.thuongmaidientu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository <EmployeeProfile, Integer>{
//    List<EmployeeProfile> findByName (String name);

}
