package com.offcn.shopping.dao;

import com.offcn.shopping.bean.User;

public interface UserDao {
public int insertUser(User user);
public User selectUsernameAndPassword(String username, String password);
}
