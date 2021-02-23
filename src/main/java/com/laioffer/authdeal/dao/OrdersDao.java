package com.laioffer.authdeal.dao;

import com.laioffer.authdeal.entity.Orders;
import com.laioffer.authdeal.repository.ItemsRepository;
import com.laioffer.authdeal.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrdersDao {
  @Autowired
  ItemsRepository itemsRepository;
  @Autowired
  OrdersRepository ordersRepository;
  public void addOrder(Orders order) {
    ordersRepository.save(order);
  }
  public List<Orders> findOrdersByBuyerId(String buyerId){
    List<Orders> ret = new ArrayList<>();
    for(Orders order : ordersRepository.findAllOrdersOfBuyer(buyerId)){
      ret.add(order);
    }
    return ret;
  }
  public List<Orders> findOrdersBySellerId(String sellerId){
    List<Orders> ret = new ArrayList<>();
    for(Orders order : ordersRepository.findAllOrdersOfSeller(sellerId)){
      ret.add(order);
    }
    return ret;
  }
  public List<Orders> findIOrders(){
    List<Orders> ret = new ArrayList<>();
    for(Orders order : ordersRepository.findAll()){
      ret.add(order);
    }
    return ret;
  }
}