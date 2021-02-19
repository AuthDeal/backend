package com.laioffer.authdeal.dao;

import com.laioffer.authdeal.entity.Items;
import com.laioffer.authdeal.repository.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
        Items item = itemsRepository.findById(itemId).get();
        return item;
    }

    public List<Items> findAllItems() {
        return (List<Items>) itemsRepository.findAll();
    }
}
