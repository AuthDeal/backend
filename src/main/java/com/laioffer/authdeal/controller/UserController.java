package com.laioffer.authdeal.controller;

import com.laioffer.authdeal.dao.UserDao;
import com.laioffer.authdeal.entity.Users;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  private UserDao userDao;

  @RequestMapping(value = "/users/all", method = RequestMethod.GET)
  public List<Users> fetchAllUsers() {
    return userDao.findAllUsers();
  }

  @GetMapping("/userInfo")
  public String userInfo(HttpSession session) {
    //从session获取User对象
    Users user = (Users) session.getAttribute("user");
    //如果用户为空，则创建新的对象
    if (user == null) {
      user = new Users();
      user.setUserName(UUID.randomUUID().toString());
      //设置默认头像
      String picture = "/0/D/359EC8DE4BE24833A4BAFA98136E0A67.jpeg";
      user.setPicture(picture);
      session.setAttribute("user",user);
    }
    //否则直接进入用户信息页面
    return "userInfo";
  }

 }
