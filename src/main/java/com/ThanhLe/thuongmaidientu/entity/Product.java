package com.ThanhLe.thuongmaidientu.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Products")
@Getter
@Setter
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    Double unitPrice;
    String image;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    Date productDate;
    Boolean available;
    //Integer categoryId;
    Integer quantity;
    String description;
    Double discount;
    Integer viewCount;
    Boolean special;

    @ManyToOne
    @JoinColumn(name="categoryId")
    Category category;


    @OneToMany(mappedBy = "product")
    List<OrderDetail> orderDetails;
}
