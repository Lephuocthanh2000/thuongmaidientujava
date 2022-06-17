package com.ThanhLe.thuongmaidientu.repository;

import com.ThanhLe.thuongmaidientu.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository {
    Users getReferenceById(Integer id);

    List<Users> findAll();

    Users create(Users entity);

    void update(Users entity);

    Users delete(Integer id);




}
