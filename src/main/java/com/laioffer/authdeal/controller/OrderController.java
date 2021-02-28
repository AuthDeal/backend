package com.laioffer.authdeal.controller;

import com.laioffer.authdeal.dao.ItemDao;
import com.laioffer.authdeal.dao.OrdersDao;
import com.laioffer.authdeal.dao.UserDao;
import com.laioffer.authdeal.entity.Items;
import com.laioffer.authdeal.entity.OrderStatus;
import com.laioffer.authdeal.entity.Orders;
import com.laioffer.authdeal.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class OrderController {
  @Autowired
  ItemDao itemDao;
  @Autowired
  UserDao userDao;
  @Autowired
  OrdersDao ordersDao;

  @RequestMapping(value ="/order/{itemId}/checkout/", method = RequestMethod.POST)
  public Map<String,Object> checkout(@PathVariable(value = "itemId") int itemId, @RequestBody Map<String,Object> json){

    Items target = itemDao.findItemById(itemId);
    Users buyer = userDao.findUserById((String)json.get("buyerId"));
    if(target!=null && buyer!=null) {
      Orders order = new Orders();
      target.setSold(true);
      //target = itemDao.addItem(target);
      order.setItem(target);
      order.setSeller(target.getUsers());
      order.setPickUp((boolean)json.get("IsPickUP"));
      order.setAddress((String)json.get("Street"));
      order.setCity((String)json.get("City"));
      order.setState((String)json.get("State"));
      order.setZipcode((String)json.get("Zipcode"));
      order.setFirstName((String)json.get("FirstName"));
      order.setLastName((String)json.get("LastName"));
      order.setCountry((String)json.get("Country"));
      order.setOrderStatus(OrderStatus.PENDING);
      order.setBuyer(buyer);
      System.out.println(order.toString());
      ordersDao.addOrder(order);
    }

    return json;
  }
  @RequestMapping(value ="/order/{buyerId}/buyer/", method = RequestMethod.GET)
  public List<Orders> checkout(@PathVariable(value = "buyerId") String buyerId){

//        Items target = itemDao.findItemsById(itemId);
//        if(target!=null){
//            Orders order = new Orders();
//            target.setSold(true);
//            target = itemDao.addItem(target);
//            order.setItem(target);
//            order.setSeller(target.getUsers());

    Users buyer = userDao.findUserById(buyerId);

    return ordersDao.findOrdersByBuyerId(buyerId);
  }
}