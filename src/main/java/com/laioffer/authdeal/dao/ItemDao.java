package com.laioffer.authdeal.dao;


import com.laioffer.authdeal.entity.Items;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDao {

//  @Autowired
//  private SessionFactory sessionFactory;

  public void addItem(Items item) {
    Session session = null;
    try {
//      session = sessionFactory.openSession();
      session.beginTransaction();
      session.saveOrUpdate(item);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
      session.getTransaction().rollback();
    } finally {
      if (session != null) {
        session.close();
      }
    }
  }

//  public void removeItem(int itemId) {
//    Session session = null;
//    try {
//      session = sessionFactory.openSession();
//      Items item = session.get(Items.class, itemId);
//    }
//  }
}
