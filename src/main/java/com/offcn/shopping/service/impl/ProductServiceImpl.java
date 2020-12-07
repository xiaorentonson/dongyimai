package com.offcn.shopping.service.impl;

import com.offcn.shopping.bean.Product;
import com.offcn.shopping.dao.ProductDao;
import com.offcn.shopping.dao.impl.ProductDaoImpl;
import com.offcn.shopping.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
   // ProductDao productDao=new ProductDaoImpl();
   private ProductDao productDao;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> findShopByState(Integer state) {
        return productDao.selectShopByState(state);

    }

    @Override
    public Product selectShopById(Integer id) {
        Product product=productDao.findShopById(id);
        return product;
    }
}
