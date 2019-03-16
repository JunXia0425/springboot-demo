package com.qianfeng.springdemo.dao;

import com.qianfeng.springdemo.bean.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

//mybatis注解实现mapper配置
//alt+enter快捷键，快速代码提示
@Mapper
public interface UserDao {
  @Select("select * from user")
  public List<User> findAll();

  @Select("select * from user where usr = #{name}")
  public User findByName(String name);
}
