package com.laioffer.authdeal.controller;

import com.laioffer.authdeal.dao.UserDao;
import com.laioffer.authdeal.entity.Users;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
 }
