package com.ThanhLe.thuongmaidientu.service;

import com.ThanhLe.thuongmaidientu.entity.Order;
import com.ThanhLe.thuongmaidientu.entity.OrderDetail;
import com.ThanhLe.thuongmaidientu.entity.Product;
import com.ThanhLe.thuongmaidientu.entity.Users;
import com.ThanhLe.thuongmaidientu.facede.CartServiceFacede;
import com.ThanhLe.thuongmaidientu.repository.OrderDetailRepository;
import com.ThanhLe.thuongmaidientu.repository.OrderRepository;
import com.ThanhLe.thuongmaidientu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImp implements OrderService{
    @Autowired
    UserRepository userRepository;

    @Autowired
    HttpSession session;

    @Autowired
    CartServiceFacede cart;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderDetailRepository orderDetailRepository;
    @Override
    public void showForm(Order order) {
        Users users = (Users) session.getAttribute("user");

        order.setOrderDate(new Date());
        order.setUsers(users);
        order.setAmount(cart.getAmount());
        order.setStatus(1);

    }

    @Override
    public void purchase(Model model, Order order) {
        Collection<Product> list = cart.getItems();
        List<OrderDetail> details = new ArrayList<>();
        for(Product product:list) {
            OrderDetail detail =new OrderDetail();
            detail.setOrder(order);
            detail.setProduct(product);
            detail.setUnitPrice(product.getUnitPrice());
            detail.setQuantity(product.getQuantity());
            detail.setDiscount(product.getDiscount());
            details.add(detail);

        }
        orderRepository.create(order, details);
        cart.clear();

        model.addAttribute("message", "Đặt hàng thành công!");
    }

    @Override
    public void orderList(Model model) {
        Users users = (Users) session.getAttribute("user");
        List<Order> orders = orderRepository.findByUser(users);
        model.addAttribute("orders", orders);
    }

    @Override
    public void orderDetail(Model model, Integer id) {
        Order order = orderRepository.getReferenceById(id);
        List<OrderDetail> details = orderDetailRepository.findByOrder(order);
        model.addAttribute("order", order);
        model.addAttribute("details", details);
    }

    @Override
    public void orderItems(Model model) {
        Users users = (Users) session.getAttribute("user");
        List<Product> list = orderRepository.findItemsByUser(users);
        model.addAttribute("list", list);
    }
}
