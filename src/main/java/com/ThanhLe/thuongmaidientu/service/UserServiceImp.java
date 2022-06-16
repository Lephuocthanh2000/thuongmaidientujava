package com.ThanhLe.thuongmaidientu.service;

import com.ThanhLe.thuongmaidientu.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImp implements UserService{
    @Autowired
    UserRepository userrepository;
    @Override
    public boolean createUser(User user1) {
        User user2 = userrepository.findById();

        return true;
    }
}
