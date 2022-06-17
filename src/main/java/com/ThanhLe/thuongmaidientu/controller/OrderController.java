package com.ThanhLe.thuongmaidientu.controller;

import com.ThanhLe.thuongmaidientu.entity.Order;

import com.ThanhLe.thuongmaidientu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @GetMapping("/checkout")
    public String showForm(@ModelAttribute("order") Order order) {
        orderService.showForm(order);
        return "order/checkout";

    }
    @PostMapping("/order/checkout")
    public String purchase(Model model,  @ModelAttribute("order") Order order){
        orderService.purchase(model, order);
        return "redirect:/order/list";

    }

    @GetMapping("/order/list")
    public String list(Model model) {
        orderService.orderList(model);
        return "order/list";
    }

    @GetMapping("/order/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        orderService.orderDetail(model, id);
        return "order/detail";
    }
    @GetMapping("/order/items")
    public String items(Model model) {
        orderService.orderItems(model);
        return "product/list_order_item";
    }
}
