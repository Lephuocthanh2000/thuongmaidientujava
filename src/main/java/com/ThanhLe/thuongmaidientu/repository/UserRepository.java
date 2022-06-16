package com.ThanhLe.thuongmaidientu.repository;

import com.ThanhLe.thuongmaidientu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository  {
    User findById(Integer id);

    List<User> findAll();

    User create(User entity);

    void update(User entity);

    User delete(String id);

    long getPageCount(int pageSize);

    List<User> getPage(int pageNo, int pageSize);
}
