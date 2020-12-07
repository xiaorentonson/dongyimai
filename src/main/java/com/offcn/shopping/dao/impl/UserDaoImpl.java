package com.offcn.shopping.dao.impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offcn.shopping.bean.User;
import com.offcn.shopping.dao.UserDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
ComboPooledDataSource dataSource=new ComboPooledDataSource();
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    /*   @Override
        public int insertUser(User user) {
            int result=0;
            QueryRunner queryRunner=new QueryRunner(dataSource);
            String sql="insert into user(username,password,email,name,sex,birthday)values(?,?,?,?,?,?)";
            try {
               result= queryRunner.update(sql,user.getUsername(),user.getPassword(),user.getEmail(),user.getName(),user.getSex(),user.getBirthday());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            return result;
        }*/
public int insertUser(User user) {

    String sql = "insert into user (username , password , sex , name , email ,birthday ) values" +
            " (?,?,?,?,?,?)";

    int result = jdbcTemplate.update(sql , user.getUsername() , user.getPassword() ,
            user.getSex() , user.getName() , user.getEmail() , user.getBirthday());

    System.out.println("这个代码执行。。。。。。");
    return result;
}


    @Override
    public User selectUsernameAndPassword(String username, String password) {
       User user=null;
        QueryRunner queryRunner=new QueryRunner(dataSource);
        String sql="select userid,username,password,email,sex,birthday from user where username=? and password=?";
        try {
            user= (User) queryRunner.query(sql, new BeanHandler(User.class),username,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }
}
