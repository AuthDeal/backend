package com.laioffer.authdeal;


import com.laioffer.authdeal.dao.OrdersDao;
import com.laioffer.authdeal.entity.Items;
import com.laioffer.authdeal.entity.Orders;
import com.laioffer.authdeal.entity.Users;
import com.laioffer.authdeal.repository.ItemsRepository;
import com.laioffer.authdeal.repository.UsersRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderTest {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    ItemsRepository itemsRepository;
    @Autowired
    OrdersDao orderDao;
    @Test
    void contextLoads() {
        Users seller = usersRepository.findById("123@gmail.com").get();
        Users buyer = usersRepository.findById("456@gmail.com").get();
        Items item = itemsRepository.findAllItemsOfSeller("123@gmail.com").get(0);
        item.setSelled(true);
        itemsRepository.save(item);
        Orders order = new Orders();
        order.setItem(item);
        order.setBuyer(buyer);
        order.setSeller(seller);
        orderDao.addOrder(order);
        for(Orders o:orderDao.findOrdersBySellerId("123@gmail.com")){
            System.out.println(o.toString());
        }
        for(Orders o:orderDao.findOrdersByBuyerId("456@gmail.com")){
            System.out.println(o.toString());
        }
    }
}
