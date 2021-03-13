package com.laioffer.authdeal.dao;

import com.laioffer.authdeal.entity.Items;
import com.laioffer.authdeal.repository.ItemsRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemDao {
  @Autowired
  private ItemsRepository itemsRepository;

  public Items addItem(Items item) {
    return itemsRepository.save(item);
  }

  public void deleteItem(int itemId) {
    itemsRepository.deleteById(itemId);
  }

  public Items findItemById(int itemId) {
    return itemsRepository.findById(itemId).get();
  }

  public List<Items> findAllItems() {
    return (List<Items>) itemsRepository.findAll();
  }

  public List<Items> findItemsBySellId(String userId){
    List<Items> ret = new ArrayList<>();
    for(Items item : itemsRepository.findAllItemsOfSeller(userId)){
      if(!item.getSold()){
        ret.add(item);
      }
    }
    return ret;
  }
}