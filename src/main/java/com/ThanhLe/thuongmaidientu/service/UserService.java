package com.ThanhLe.thuongmaidientu.service;

import com.ThanhLe.thuongmaidientu.entity.Users;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface UserService {
   boolean createUser(Model model,  MultipartFile file,Users entity)throws IllegalStateException, IOException ;
    void userShow(Model model);
    void userEdit(Model model,Integer id);
    void userDelete(Model model,Integer id1,Integer id2);
    void userUpdate(Model model,  MultipartFile file, Users entity)throws IllegalStateException, IOException;
    long pageCount(Integer pageSize);
    List<Users> getPage(Integer pageNo, Integer pageSize);
}
