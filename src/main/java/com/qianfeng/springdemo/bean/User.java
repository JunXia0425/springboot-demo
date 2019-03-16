package com.qianfeng.springdemo.bean;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class User {

  private String usr;
  private String pwd;

}
