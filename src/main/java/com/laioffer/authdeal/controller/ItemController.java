package com.laioffer.authdeal.controller;

import com.laioffer.authdeal.dao.ItemDao;
import com.laioffer.authdeal.entity.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
public class ItemController {
    @Autowired
    private ItemDao itemDao;

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public List<Items> fetchAllItems() {
        return itemDao.findAllItems();
    }

    @RequestMapping(value = "/item/{itemId}", method = RequestMethod.GET)
    public Items fetchItemByID(@PathVariable(value = "itemId") int itemId){
        return itemDao.findItemById(itemId);
    }

    @RequestMapping(value = "/item", method = RequestMethod.POST)
    public Items postItem(Items item) {
        itemDao.addItem(item);
        return item;
    }

    @RequestMapping(value = "/items/{itemId}",method = RequestMethod.DELETE)
    public void deleteItem(@PathVariable(value = "itemId") int itemId) {
        itemDao.deleteItem(itemId);
    }
}
