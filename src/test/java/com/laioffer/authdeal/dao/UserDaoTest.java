package com.laioffer.authdeal.dao;

import com.laioffer.authdeal.entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserDaoTest {
  @Autowired
  UserDao userDao;

  @Test
  void createUsers() {
    System.out.println("Hello world!");
    Users user1 = new Users();
    user1.setUserName("anson3@authdeal.com");
    user1.setPassword("anson3@authdeal.com");
    user1.setEnabled(true);
    user1.setPhoneNum("4251234567");
    user1.setRate(4.6f);
    user1.setPicture("picture url");

    userDao.createUsers(user1);
    System.out.println(user1.toString());
  }

  @Test
  void findUserById() {
    Users result = userDao.findUserById("anson@authdeal.com");
    System.out.println(result.toString());
    System.out.println();
    System.out.println(userDao.findUserById("anson2@authdeal.com").toString());
  }

  @Test
  void findAllUsers() {
    System.out.println("Hello world3!");
  }
}