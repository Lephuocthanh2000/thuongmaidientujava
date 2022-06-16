package com.ThanhLe.thuongmaidientu.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "OrderDetails")
@Getter
@Setter
@Data
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    //Integer orderId;
    //Integer productId;
    Double unitPrice;
    Integer quantity;
    Double discount;

    @ManyToOne
    @JoinColumn(name="orderId")
    Order order;

    @ManyToOne
    @JoinColumn(name="productId")
    Product product;
}
