package com.ThanhLe.thuongmaidientu.repository;

import com.ThanhLe.thuongmaidientu.entity.Order;
import com.ThanhLe.thuongmaidientu.entity.OrderDetail;
import com.ThanhLe.thuongmaidientu.entity.Product;
import com.ThanhLe.thuongmaidientu.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository  {
    Order findById(Integer id);

    List<Order> findAll();

    Order create(Order entity);

    void update(Order entity);

    Order delete(Integer id);

    void create(Order order, List<OrderDetail> details);

    List<Order> findByUser(Users user);

    List<Product> findItemsByUser(Users user);
}
