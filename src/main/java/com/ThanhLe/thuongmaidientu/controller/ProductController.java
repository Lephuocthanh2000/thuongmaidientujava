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
            return " Tạo mới cookie sản phẩm yêu thích";
        } else if (result=="false") {
            return "Gặp lỗi trong quá trình thêm sản phẩm yêu thích";

        }
        return "thêm sản phẩm yêu thích thành công";
    }

    @ResponseBody
    @RequestMapping("/send-to-friend")
    public String sendToFriend(Model model, MailInfo info, HttpServletRequest req) {
       if(productService.sendToFriend(model,info,req)==true){
           return "Gửi đơn thông tin thành công";
       }else{
           return "Gửi đơn thông tin thất bại";
       }
    }

    @RequestMapping("/favorite")
    public String favo(Model model) {
        productService.favo(model);
        return "product/favorite";
    }

}
