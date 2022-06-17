package com.ThanhLe.thuongmaidientu.service;

import com.ThanhLe.thuongmaidientu.bean.MailInfo;
import org.springframework.ui.Model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public interface ProductService {
    void listByCategory(Model model,Integer categoryId);

    void listByKeywords(Model model, String keywords);
    void listBySpecial(Model model,Integer categoryId);
    void listByNews(Model model,Integer categoryId);
    String addToFavorite(Model model, Integer id);
    void detail(Model model, Integer id);
    boolean sendToFriend(Model model, MailInfo info, HttpServletRequest req);

    void favo(Model model);
}
