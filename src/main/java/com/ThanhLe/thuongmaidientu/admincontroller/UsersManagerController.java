package com.ThanhLe.thuongmaidientu.admincontroller;

import com.ThanhLe.thuongmaidientu.entity.Users;
import com.ThanhLe.thuongmaidientu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/admin/customer")
public class UsersManagerController {
    @Autowired
    UserService userservice;
    @RequestMapping("/index")
    public String index(Model model) {
        userservice.userShow(model);
        return "admin/customer/index";
    }

    @RequestMapping("/admin/customer/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id) {
        userservice.userEdit(model,id);
        return "admin/customer/index";
    }

    @RequestMapping("/create")
    public String create(RedirectAttributes model, @Validated @ModelAttribute("entity") Users entity,
                         @RequestParam("photo_file") MultipartFile file) throws IllegalStateException, IOException {
        if(userservice.createUser(model,file,entity)==false){
            return "redirect:/admin/customer/index";
        }

        return "redirect:/admin/customer/index";
    }

    @RequestMapping("/update")
    public String update(RedirectAttributes model, @ModelAttribute("entity") Users entity,
                         @RequestParam("photo_file") MultipartFile file)throws IllegalStateException, IOException {
        userservice.userUpdate(model,file,entity);
        return "redirect:/admin/customer/edit/" + entity.getId();
    }

    @RequestMapping(value = { "/admin/customer/delete", "/admin/customer/delete/{id}" })
    public String delete(RedirectAttributes model, @RequestParam(value = "id", required = false) Integer id1,
                         @PathVariable(value = "id", required = false) Integer id2) {
        userservice.userDelete(model,id1,id2);
        return "redirect:/admin/customer/index";
    }


    int pageSize = 8;
    @RequestMapping("/pager/customer/page-count")
    public long pageCount() {

        return userservice.pageCount(pageSize);
    }
    
    @RequestMapping("/pager/customer/page/{pageNo}")
    public List<Users> getPage(@PathVariable("pageNo") int pageNo) {
       return userservice.getPage(pageNo,pageSize);
    }
}
