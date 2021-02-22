package com.laioffer.authdeal;

import com.laioffer.authdeal.entity.*;
import com.laioffer.authdeal.repository.ItemsRepository;
import com.laioffer.authdeal.repository.UsersRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class AuthdealApplicationTests {
  @Autowired
  UsersRepository usersRepository;
  @Autowired
  ItemsRepository itemsRepository;
  @Test
  void contextLoads() {
    Users seller = new Users();
    seller.setUserName("123@gmail.com");
    seller.setPassword("123");
    seller.setPhoneNum("123-456-7890");
    usersRepository.save(seller);

    Items item1 = new Items();
    item1.setItemName("iphone99");
    item1.setDescription("bigger than bigger");
    item1.setUsers(seller);
    Items item2 = new Items();
    item2.setItemName("CovidVaccine");
    item2.setDescription("sugger water");
    item2.setUsers(seller);
    itemsRepository.save(item1);
    itemsRepository.save(item2);

    seller = usersRepository.findById("123@gmail.com").get();
    List<Items> ret = new ArrayList<>();
    for(Items item : itemsRepository.findAllItemsOfSeller(seller.getUserName())){
      ret.add(item);
    }
    for(Items item : ret){
      System.out.println(item.toString());
    }

  }

}
