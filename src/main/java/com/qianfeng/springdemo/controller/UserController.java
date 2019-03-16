package com.qianfeng.springdemo.controller;

import com.qianfeng.springdemo.bean.User;
import com.qianfeng.springdemo.service.UserService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping("/showall")
  @ResponseBody
  public List<User> showAll() {
    return userService.findAll();
  }

  @RequestMapping("/login")
  public String login(ModelMap modelMap) {
    modelMap.put("User", new User());//要传一个空user对象给前端，接值
    return "login";
  }

  //普通Servlet方式
//  @RequestMapping("validata")
//  public String val(@RequestParam("usr") String usrname,@RequestParam("pwd") String password){
//    User user = new User();
//    user.setUsr(usrname);
//    user.setPwd(password);
//    boolean authTrue = userService.isAuthTrue(user);
//    if (authTrue){
//      return "success";
//    }
//    return "failed";
//  }
//  Thymeleaf方式
  @RequestMapping("validata")
  public String val(@ModelAttribute User user, ModelMap map) {
//    modelMap可以将数据传递给下一个页面
    boolean authTrue = userService.isAuthTrue(user);
    if (authTrue) {
      map.put("username", user.getUsr());//将用户名传给成功页面
      return "success";
    }
    return "failed";
  }
}
