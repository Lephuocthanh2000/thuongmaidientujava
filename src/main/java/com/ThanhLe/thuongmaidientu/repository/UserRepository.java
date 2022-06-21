package com.ThanhLe.thuongmaidientu.repository;

import com.ThanhLe.thuongmaidientu.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserRepository  {
    Users findById(Integer id);

    List<Users> findAll();

    Users create(Users entity);

    void update(Users entity);

    Users delete(Integer id);

    long getPageCount(int pageSize);

    List<Users> getPage(int pageNo, int pageSize);


}
