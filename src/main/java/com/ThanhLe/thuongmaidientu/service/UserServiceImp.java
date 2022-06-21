package com.ThanhLe.thuongmaidientu.service;

import java.io.File;
import java.io.IOException;
import java.util.List;


import javax.servlet.ServletContext;

import com.ThanhLe.thuongmaidientu.entity.Users;
import com.ThanhLe.thuongmaidientu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import org.springframework.web.multipart.MultipartFile;



@Service
public class UserServiceImp implements UserService{
    @Autowired
    UserRepository userRepository;

    @Autowired
    ServletContext app;
    @Override
    public boolean createUser(Model model,  MultipartFile file,Users entity) throws IllegalStateException,IOException{
        Users Users2 = userRepository.findById(entity.getId());
        if (Users2 != null) {
            model.addAttribute("message", "Tên đăng nhập đã được sử dụng!");
            return false;
        }

        if (file.isEmpty()) {
            entity.setPhoto("Users.png");
        } else {
            entity.setPhoto(file.getOriginalFilename());
            String path = app.getRealPath("/static/images/customers/" + entity.getPhoto());
            file.transferTo(new File(path));
        }

        userRepository.create(entity);
        model.addAttribute("message", "Thêm mới thành công!");

        return true;
    }



    @Override
    public void userShow(Model model) {
        Users entity = new Users();
        model.addAttribute("entity", entity);
        model.addAttribute("list", userRepository.findAll());
    }

    @Override
    public void userEdit(Model model,Integer id) {
        Users entity = userRepository.findById(id);
        model.addAttribute("entity", entity);
        model.addAttribute("list", userRepository.findAll());
    }

    @Override
    public void userDelete(Model model,Integer id1,Integer id2) {
        if (id1 != null) {
            userRepository.delete(id1);
        } else {
            userRepository.delete(id2);
        }

        model.addAttribute("message", "Xóa thành công!");
    }

    @Override
    public void userUpdate(Model model, MultipartFile file,Users entity) throws IllegalStateException, IOException {
        if (!file.isEmpty()) {
            entity.setPhoto(file.getOriginalFilename());
            String path = app.getRealPath("/static/images/customers/" + entity.getPhoto());
            file.transferTo(new File(path));
        }
        userRepository.update(entity);
        model.addAttribute("message", "Cập nhật thành công!");
    }

    @Override
    public long pageCount(Integer pageSize) {
        return userRepository.getPageCount(pageSize);
    }

    @Override
    public List<Users> getPage(Integer pageNo, Integer pageSize) {
        List<Users> list = userRepository.getPage(pageNo, pageSize);
        return list;
    }
}
