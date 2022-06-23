package com.ThanhLe.thuongmaidientu.controller;

import com.ThanhLe.thuongmaidientu.entity.Product;
import com.ThanhLe.thuongmaidientu.repository.ProductRepository;
import com.ThanhLe.thuongmaidientu.repository.ProductRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {
    @Autowired
    ProductRepositoryImp pdao;

    @RequestMapping(value = {"", "/home"})
    public List<Product> index(Model model) {
        List<Product> list2 = pdao.findBySpecial(4);
        model.addAttribute("list", list2);
        List<Product> list3 = pdao.findBySpecial(0);
        model.addAttribute("list1", list3);
        return list3;
    }
    @RequestMapping("/about")
    public String about() {
        return "home/about";
    }
    @RequestMapping("/contact")
    public String contact() {
        return "home/contact";
    }
    @RequestMapping("/feedback")
    public String feedback() {
        return "home/feedback";
    }
    @RequestMapping("/faq")
    public String faq() {
        return "home/faq";
    }

    @ResponseBody
    @RequestMapping("/home/language")
    public String language() {
        return "English";
    }
}
