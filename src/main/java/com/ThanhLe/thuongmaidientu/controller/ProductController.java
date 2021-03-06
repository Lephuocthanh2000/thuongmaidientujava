package com.ThanhLe.thuongmaidientu.controller;


import com.ThanhLe.thuongmaidientu.bean.MailInfo;
import com.ThanhLe.thuongmaidientu.entity.Product;
import com.ThanhLe.thuongmaidientu.repository.ProductRepository;
import com.ThanhLe.thuongmaidientu.facede.CookieService;
import com.ThanhLe.thuongmaidientu.facede.MailService;
import com.ThanhLe.thuongmaidientu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;


    @RequestMapping("/list-by-category/{cid}")
    public String listByCategory(Model model, @PathVariable("cid") Integer categoryId) {
        productService.listByCategory(model,categoryId);
        return "product/list";
    }

    @RequestMapping("/list-by-categorys/{cid}")
    public String listByCategorys(Model model, @PathVariable("cid") Integer categoryId) {
        productService.listByCategory(model,categoryId);
        return "product/list_copy";
    }

    @RequestMapping("/list-by-keywords")
    public String listByKeywords(Model model, @RequestParam("keywords") String keywords) {
        productService.listByKeywords(model,keywords);
        return "product/list";
    }

    @RequestMapping("/list-by-special/{id}")
    public String listBySpecial(Model model, @PathVariable("id") Integer id) {
        productService.listBySpecial(model,id);
        return "product/list_special_full";
    }
    @RequestMapping("/list-by-new/{id}")
    public String listByNews(Model model, @PathVariable("id") Integer id) {
        productService.listByNews(model, id);
        return "product/list-by-new_full";
    }


    @RequestMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        productService.detail(model,id);
        return "product/detail";
    }


    @ResponseBody
    @RequestMapping("/add-to-favo/{id}")
    public String addToFavorite(Model model, @PathVariable("id") Integer id) {
        String result = productService.addToFavorite(model,id);
        if(result=="true"){
            return " T???o m???i cookie s???n ph???m y??u th??ch";
        } else if (result=="false") {
            return "G???p l???i trong qu?? tr??nh th??m s???n ph???m y??u th??ch";

        }
        return "th??m s???n ph???m y??u th??ch th??nh c??ng";
    }

    @ResponseBody
    @RequestMapping("/send-to-friend")
    public String sendToFriend(Model model, MailInfo info, HttpServletRequest req) {
       if(productService.sendToFriend(model,info,req)==true){
           return "G???i ????n th??ng tin th??nh c??ng";
       }else{
           return "G???i ????n th??ng tin th???t b???i";
       }
    }

    @RequestMapping("/favorite")
    public String favo(Model model) {
        productService.favo(model);
        return "product/favorite";
    }

}
