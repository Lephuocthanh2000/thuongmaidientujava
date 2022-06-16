package com.ThanhLe.thuongmaidientu.repository;

import com.ThanhLe.thuongmaidientu.entity.Product;

import java.util.List;


public interface ProductRepository {
    public Product findById(Integer id);
    public List<Product> findAll();
    public Product create(Product entity);
    public void update(Product entity);
    public Product delete(Integer id);
    public List<Product> findByCategoryId(Integer categoryId);
    public List<Product> findByKeywords(String keywords);
    public List<Product> findByIds(String ids);
    public List<Product> findBySpecial(Integer id);
}
