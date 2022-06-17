package com.ThanhLe.thuongmaidientu.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Orders")
@Getter
@Setter
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    //String userId;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    Date orderDate;
    String telephone;
    String address;
    Double amount;
    String description;
    Integer status;

    @ManyToOne
    @JoinColumn(name="userId")
    Users users;


    @OneToMany(mappedBy = "order")
    List<OrderDetail> orderDetails;

}
