package com.laioffer.authdeal.dao;

import com.laioffer.authdeal.entity.Messages;
import com.laioffer.authdeal.entity.Users;
import java.sql.Timestamp;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MessageDaoTest {

  @Autowired
  MessageDao messageDao;

  @Autowired
  UserDao userDao;

  @Test
  void createMsg() {
    System.out.println("Testing to create a message.");
    Users from = new Users("msgFrom3", "msgFrom3",
        true, 5.0f, "picture url","4251234567");
    userDao.createUsers(from);

    Users to = new Users("msgTo4", "msgTo4",
        true, 5.0f, "picture url","4251234567");
    userDao.createUsers(to);

    Messages msg1 = new Messages(2, from, to, "message content",
        false, new Timestamp(System.currentTimeMillis()));
    messageDao.createMsg(msg1);
    System.out.println(msg1.toString());
  }

  @Test
  void findMsgById() {
    System.out.println("Testing to find Message By Id.");
    Messages message = messageDao.findMsgById(1);
    System.out.println(message.toString());
  }

  @Test
  void findAllMsgs() {
    System.out.println("Testing to find all messages");
    List<Messages> result = messageDao.findAllMsgs();
    for (Messages msg : result) {
      System.out.println(msg.toString());
    }
  }
}