package com.offcn.shopping.service;

import com.offcn.shopping.bean.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findShopByState(Integer state);
    public Product selectShopById(Integer id);
}
