package com.ThanhLe.thuongmaidientu.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Categories")
@Getter
@Setter
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String nameVN;

    @OneToMany(mappedBy="category")
    List<Product> products;

}
