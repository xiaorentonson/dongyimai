package com.offcn.shopping.service.impl;

import com.offcn.shopping.bean.User;
import com.offcn.shopping.dao.UserDao;
import com.offcn.shopping.dao.impl.UserDaoImpl;
import com.offcn.shopping.service.UserService;

public class UserServiceImpl implements UserService {
    //UserDao userDao=new UserDaoImpl();
     private  UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Boolean addUser(User user) {

        int result=userDao.insertUser(user);
        if(1==result){
            return true;
        }
        return false;
    }

    @Override
    public User selectByUsernameAndPassword(String username, String password) {
        User user=userDao.selectUsernameAndPassword(username,password);
        return user;
    }
}
