package com.offcn.shopping.dao.impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offcn.shopping.bean.Product;
import com.offcn.shopping.dao.ProductDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    ComboPooledDataSource dataSource=new ComboPooledDataSource();
    public List<Product> selectShopByState(Integer state){
        QueryRunner queryRunner=new QueryRunner(dataSource);
        String sql="select pro_id proId , pro_name proName , pro_num proNum , " +
                " market_price marketPrice , shop_price shopPrice , pro_color proColor, " +
                " pro_total_count proTotalCount , pro_min_img proMinImg , pro_state proState " +
                " from product " +
                " where pro_state = ?";
        List<Product> list=null;
        try {
            list=queryRunner.query(sql,new BeanListHandler<>(Product.class),state);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public Product findShopById(Integer id) {
        String sql="select pro_id proId,pro_name proName,pro_num proNum,"+
                " market_price marketPrice,shop_price shopPrice, pro_color proColor," +
                " pro_total_count proTotalCount , pro_min_img proMinImg , pro_state proState " +
                " from product " +
                " where pro_id = ?";
        QueryRunner queryRunner=new QueryRunner(dataSource);
        Product product=null;
        try {
            product=queryRunner.query(sql,new BeanHandler<>(Product.class),id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }


}
