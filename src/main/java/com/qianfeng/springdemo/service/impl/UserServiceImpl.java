package com.qianfeng.springdemo.service.impl;

import com.qianfeng.springdemo.bean.User;
import com.qianfeng.springdemo.dao.UserDao;
import com.qianfeng.springdemo.service.UserService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDao userDao;

  @Override
  public List<User> findAll() {
    log.info("这里进行了数据操作~~~");
    return userDao.findAll();
  }

  @Override
  public boolean isAuthTrue(User user) {
    String usr = user.getUsr();
    String pwd = user.getPwd();
    User byName = userDao.findByName(usr);
//    inn: if not null
    if (byName != null) {
      if (pwd.equals(byName.getPwd())) {
        return true;
      }
    }
    return false;
  }
}
