package com.ThanhLe.thuongmaidientu.facede;

import com.ThanhLe.thuongmaidientu.entity.Product;

import java.util.Collection;

public interface CartServiceFacede {
    public void add(Integer id);
    public void remove(Integer id);
    public void update(Integer id, int qty);
    public void clear();
    public int getCount();
    public double getAmount();
    public Collection<Product> getItems();


}
