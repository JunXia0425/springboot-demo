package com.qianfeng.springdemo.dao;

import static org.junit.Assert.*;

import com.qianfeng.springdemo.bean.User;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
  @Autowired
  private UserDao userDao;
  //测试方法
  @Test
  public void testSelectAll(){

    List<User> all = userDao.findAll();
    Assert.assertEquals(2,all.size());
  }

}