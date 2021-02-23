package com.laioffer.authdeal.dao;

import com.laioffer.authdeal.entity.ItemCondition;
import com.laioffer.authdeal.entity.Items;
import com.laioffer.authdeal.entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class ItemDaoTest {

  @Autowired
  UserDao usersDao;

  @Autowired
  ItemDao itemDao;
  @Test
  void addItem() {
      Users user1 = new Users();
      Users user2 = new Users();
      user1.setUserName("12");
      user1.setPassword("aaaaaaa");
      usersDao.createUsers(user1);

      user2.setUserName("34");
      user2.setPassword("aaaaaaa");
      usersDao.createUsers(user2);

      Items item1 = new Items(user1, "printer", 63.0f, "picture",
              "Perfect cheap price printer", ItemCondition.LIKENEW, 77007);
      itemDao.addItem(item1);

      Items item2 = new Items(user2, "cellphone", 46.0f, "picture",
              "good condition cellphone", ItemCondition.GOOD, 70001);
      itemDao.addItem(item2);

      for(Items item: itemDao.findAllItems()){
          System.out.println(item.toString());
      }
  }

  @Test
  void deleteItem() {
    itemDao.deleteItem(1);
  }

  @Test
  void findItemById() {
    Items item = itemDao.findItemById(4);
    System.out.println(item.toString());
  }

  @Test
  void findAllItems() {
    List<Items> items = itemDao.findAllItems();
    System.out.println(items);
  }
}