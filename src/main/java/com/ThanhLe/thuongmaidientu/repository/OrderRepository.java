package com.ThanhLe.thuongmaidientu.repository;

import com.ThanhLe.thuongmaidientu.entity.Order;
import com.ThanhLe.thuongmaidientu.entity.OrderDetail;
import com.ThanhLe.thuongmaidientu.entity.Product;
import com.ThanhLe.thuongmaidientu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    Order getReferenceById(Integer id);

    List<Order> findAll();

    Order create(Order entity);

    void update(Order entity);

    Order delete(Integer id);

    void create(Order order, List<OrderDetail> details);

    List<Order> findByUser(User user);

    List<Product> findItemsByUser(User user);
}
