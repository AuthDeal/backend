package com.laioffer.authdeal.contoller;

import com.laioffer.authdeal.dao.ItemDao;
import com.laioffer.authdeal.dao.MessagesDao;
import com.laioffer.authdeal.dao.OrdersDao;
import com.laioffer.authdeal.dao.UserDao;
import com.laioffer.authdeal.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class ItemsController {
    @Autowired
    ItemDao itemDao;
    @Autowired
    UserDao userDao;
    @Autowired
    MessagesDao messagesDao;
    @Autowired
    OrdersDao ordersDao;
    @RequestMapping(value ="/seller/{sellId}/items", method = RequestMethod.GET)
    public Map<String,Object> sellAndItsItems(@PathVariable(value = "sellId") String sellId){
        Map<String,Object> map = new HashMap<>();
        Users seller = userDao.findUserById(sellId);
        if(seller!=null){
            map.put("seller",seller);
            map.put("items",itemDao.findItemsBySellId(sellId));
        }
        return map;
    }
    @RequestMapping(value ="/seller/{sellId}/dashboard", method = RequestMethod.GET)
    public Map<String,Object> sellDashboard(@PathVariable(value = "sellId") String sellId) {
        Map<String, Object> map = new HashMap<>();
        Users seller = userDao.findUserById(sellId);
        if (seller != null) {
            map.put("seller", seller);
            map.put("items", itemDao.findItemsBySellId(sellId));
            map.put("massage",messagesDao.FindAllMassageByUser(sellId));
            map.put("order",ordersDao.findOrdersBySellerId(sellId));
        }
        return map;
    }
}
