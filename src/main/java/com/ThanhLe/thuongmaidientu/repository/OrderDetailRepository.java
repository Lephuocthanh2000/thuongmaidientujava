package com.ThanhLe.thuongmaidientu.repository;

import com.ThanhLe.thuongmaidientu.entity.Order;
import com.ThanhLe.thuongmaidientu.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository  {
    OrderDetail findById(Integer id);

    List<OrderDetail> findAll();

    OrderDetail create(OrderDetail entity);

    void update(OrderDetail entity);

    OrderDetail delete(Integer id);

    List<OrderDetail> findByOrder(Order order);
}
