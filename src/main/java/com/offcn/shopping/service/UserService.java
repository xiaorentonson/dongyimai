package com.offcn.shopping.service;

import com.offcn.shopping.bean.User;

public interface UserService {
 public Boolean addUser(User user);
 public User selectByUsernameAndPassword(String username, String password);
}
