package com.laioffer.authdeal.dao;


import com.laioffer.authdeal.entity.Items;
import com.laioffer.authdeal.repository.ItemsRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemDao {

//  @Autowired
//  private SessionFactory sessionFactory;
  @Autowired
  ItemsRepository itemsRepository;
  public Items addItem(Items item) {
    return itemsRepository.save(item);
  }
  public List<Items> findItemsBySellId(String userId){
    List<Items> ret = new ArrayList<>();
    for(Items item : itemsRepository.findAllItemsOfSeller(userId)){
      if(!item.getSelled()){
        ret.add(item);
      }
    }
    return ret;
  }
  public Items findItemsById(int id){
    return itemsRepository.findById(id).get();
  }
//  public void removeItem(int itemId) {
//    Session session = null;
//    try {
//      session = sessionFactory.openSession();
//      Items item = session.get(Items.class, itemId);
//    }
//  }
}
