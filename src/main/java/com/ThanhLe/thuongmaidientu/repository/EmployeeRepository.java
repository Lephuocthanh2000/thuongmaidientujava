package com.ThanhLe.thuongmaidientu.repository;


import com.ThanhLe.thuongmaidientu.entity.EmployeeProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository <EmployeeProfile, Integer>{
//    List<EmployeeProfile> findByName (String name);

}
