package com.offcn.shopping.dao;

import com.offcn.shopping.bean.Product;

import java.util.List;

public interface ProductDao {
    public List<Product> selectShopByState(Integer state);
    public Product findShopById(Integer id);
}
