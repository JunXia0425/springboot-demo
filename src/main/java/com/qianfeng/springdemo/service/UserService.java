package com.qianfeng.springdemo.service;

import com.qianfeng.springdemo.bean.User;
import java.util.List;


public interface UserService {

  public List<User> findAll();

  boolean isAuthTrue(User user);

}
