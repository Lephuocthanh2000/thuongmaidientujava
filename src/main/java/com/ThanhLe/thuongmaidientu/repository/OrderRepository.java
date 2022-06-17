package com.ThanhLe.thuongmaidientu.repository;

import com.ThanhLe.thuongmaidientu.entity.Order;
import com.ThanhLe.thuongmaidientu.entity.OrderDetail;
import com.ThanhLe.thuongmaidientu.entity.Product;
import com.ThanhLe.thuongmaidientu.entity.Users;
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

    List<Order> findByUser(Users users);

    List<Product> findItemsByUser(Users users);
}
