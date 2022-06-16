package com.ThanhLe.thuongmaidientu.controller;


import com.ThanhLe.thuongmaidientu.bean.MailInfo;
import com.ThanhLe.thuongmaidientu.entity.Product;
import com.ThanhLe.thuongmaidientu.repository.ProductRepository;
import com.ThanhLe.thuongmaidientu.facede.CookieService;
import com.ThanhLe.thuongmaidientu.facede.MailService;
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
    ProductRepository pdao;

    @Autowired
    CookieService cookie;

    @Autowired
    MailService mail;

    @RequestMapping("/list-by-category/{cid}")
    public String listByCategory(Model model, @PathVariable("cid") Integer categoryId) {
        List<Product> list = pdao.findByCategoryId(categoryId);
        model.addAttribute("list", list);
        return "product/list";
    }

    @RequestMapping("/list-by-categorys/{cid}")
    public String listByCategorys(Model model, @PathVariable("cid") Integer categoryId) {
        List<Product> list = pdao.findByCategoryId(categoryId);
        model.addAttribute("list", list);
        return "product/list_copy";
    }

    @RequestMapping("/list-by-keywords")
    public String listByKeywords(Model model, @RequestParam("keywords") String keywords) {
        List<Product> list = pdao.findByKeywords(keywords);
        model.addAttribute("list5", list);
        return "product/list";
    }

    @RequestMapping("/list-by-special/{id}")
    public String listBySpecial(Model model, @PathVariable("id") Integer id) {
        List<Product> list = pdao.findBySpecial(id);
        model.addAttribute("list", list);
        return "product/list_special_full";
    }
    @RequestMapping("/list-by-new/{id}")
    public String listByNews(Model model, @PathVariable("id") Integer id) {
        List<Product> list = pdao.findBySpecial(id);
        model.addAttribute("list1", list);
        return "product/list-by-new_full";
    }


    @RequestMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Product prod = pdao.findById(id);
        model.addAttribute("prod", prod);

        // Tăng số lần xem
        prod.setViewCount(prod.getViewCount() + 1);
        pdao.update(prod);

        // Hàng cùng loại
//        List<Product> list = pdao.findByCategoryId(prod.getCategory().getId());
//        model.addAttribute("list", list);

        // Hàng yêu thích
        Cookie favo = cookie.read("favo");
        if (favo != null) {
            String ids = favo.getValue();
            List<Product> favo_list = pdao.findByIds(ids);
            model.addAttribute("favo", favo_list);
        }

        // Hàng đã xem
        Cookie viewed = cookie.read("viewed");
        String value = id.toString();
        if (viewed != null) {
            value = viewed.getValue();
            value += "," + id.toString();
        }
        cookie.create("viewed", value, 10);
        List<Product> viewed_list = pdao.findByIds(value);
        model.addAttribute("viewed", viewed_list);

        return "product/detail";
    }


    @ResponseBody
    @RequestMapping("/add-to-favo/{id}")
    public String addToFavorite(Model model, @PathVariable("id") Integer id) {
        Cookie favo = cookie.read("favo");
        String value = id.toString();
        if (favo != null) {
            value = favo.getValue();
            if (!value.contains(id.toString())) {
                value += "," + id.toString();
            }else {
                return "false";
            }
        }
        cookie.create("favo", value, 30);
        return "true";

    }

    @ResponseBody
    @RequestMapping("/send-to-friend")
    public String sendToFriend(Model model, MailInfo info, HttpServletRequest req) {
        //send mail
        info.setSubject("Thông tin hàng hóa");
        try {
            String id=req.getParameter("id");
            String link=req.getRequestURL().toString().replace("send-to-friend", "detail/"+id);
            info.setBody(info.getBody()+"<hr><a href='"+link+"'>Xem chi tiết...</a>");
            mail.send(info);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }

    @RequestMapping("/favorite")
    public String favo(Model model) {

        // Hàng yêu thích
        Cookie favo = cookie.read("favo");
        if (favo != null) {
            String ids = favo.getValue();
            List<Product> favo_list = pdao.findByIds(ids);
            model.addAttribute("favo", favo_list);
        }
        return "product/favorite";
    }

}
