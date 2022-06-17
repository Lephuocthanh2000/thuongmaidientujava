package com.ThanhLe.thuongmaidientu.service;

import com.ThanhLe.thuongmaidientu.bean.MailInfo;
import com.ThanhLe.thuongmaidientu.entity.Product;
import com.ThanhLe.thuongmaidientu.facede.CookieService;
import com.ThanhLe.thuongmaidientu.facede.MailService;
import com.ThanhLe.thuongmaidientu.repository.ProductRepository;
import javax.servlet.http.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Service
public class ProductServiceImp implements ProductService{
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CookieService cookie;
    @Autowired
    MailService mail;
    @Override
    public void listByCategory(Model model, Integer categoryId) {
        List<Product> list = productRepository.findByCategoryId(categoryId);
        model.addAttribute("list", list);
    }


    @Override
    public void listByKeywords(Model model,  String keywords) {
        List<Product> list = productRepository.findByKeywords(keywords);
        model.addAttribute("list5", list);
    }

    @Override
    public void listBySpecial(Model model, Integer categoryId) {
        List<Product> list = productRepository.findBySpecial(categoryId);
        model.addAttribute("list", list);
    }

    @Override
    public void listByNews(Model model, Integer id) {
        List<Product> list = productRepository.findBySpecial(id);
        model.addAttribute("list1", list);

    }

    @Override
    public String addToFavorite(Model model, Integer id) {
        Cookie favo = cookie.read("favo");
        String value = id.toString();
        if (favo != null) {
            value = favo.getValue();
            if (!value.contains(id.toString())) {
                value += "," + id.toString();
                return value;
            }else {
                return "false";
            }
        }
        cookie.create("favo", value, 30);
        return "true";
    }

    @Override
    public void detail(Model model, Integer id) {
        Product prod = productRepository.findById(id);
        model.addAttribute("prod", prod);

        // Tăng số lần xem
        prod.setViewCount(prod.getViewCount() + 1);
        productRepository.update(prod);

        // Hàng cùng loại
//        List<Product> list = pdao.findByCategoryId(prod.getCategory().getId());
//        model.addAttribute("list", list);

        // Hàng yêu thích
        Cookie favo = cookie.read("favo");
        if (favo != null) {
            String ids = favo.getValue();
            List<Product> favo_list = productRepository.findByIds(ids);
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
        List<Product> viewed_list = productRepository.findByIds(value);
        model.addAttribute("viewed", viewed_list);
    }

    @Override
    public boolean sendToFriend(Model model, MailInfo info, HttpServletRequest req) {
        //send mail
        info.setSubject("Happy Shop Thông báo Thông tin hàng hóa ");
        try {
            String id=req.getParameter("id");
            String link=req.getRequestURL().toString().replace("send-to-friend", "detail/"+id);
            info.setBody(info.getBody()+"<hr><a href='"+link+"'>Xem chi tiết...</a>");
            mail.send(info);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void favo(Model model) {
        // Hàng yêu thích
        Cookie favo = cookie.read("favo");
        if (favo != null) {
            String ids = favo.getValue();
            List<Product> favo_list = productRepository.findByIds(ids);
            model.addAttribute("favo", favo_list);
        }

    }
}
