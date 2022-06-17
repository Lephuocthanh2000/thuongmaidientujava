package com.ThanhLe.thuongmaidientu.service;

import com.ThanhLe.thuongmaidientu.entity.Order;
import org.springframework.ui.Model;

public interface OrderService {
    void showForm(Order order);
    void purchase(Model model, Order order);

    void orderList(Model model);

    void orderDetail(Model model, Integer id);

    void orderItems(Model model);
}
