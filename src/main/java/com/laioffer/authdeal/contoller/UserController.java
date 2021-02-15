package com.laioffer.authdeal.contoller;

import com.laioffer.authdeal.dao.UserDao;
import com.laioffer.authdeal.entity.Users;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  private UserDao userDao;

  @RequestMapping("/users/all")
  public List<Users> fetchAllUsers() {
    return userDao.findAllUsers();
  }
 }
