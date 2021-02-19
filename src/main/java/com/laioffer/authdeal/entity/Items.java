package com.laioffer.authdeal.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class Items implements Serializable {

  private static final long serialVersionUID = -2455760938054036364L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int itemId;

  @ManyToOne
  private Users users;
  private String itemName;
  private float price;
  private String picture;
  private String description;

  @Enumerated(EnumType.STRING)
  private ItemCondition itemCondition;

  private int zipcode;

  public Items() {
  }

  public Items( Users user, String itemName, float price, String picture,
               String description, ItemCondition itemCondition, int zipcode) {
    this.users = user;
    this.itemName = itemName;
    this.price = price;
    this.picture = picture;
    this.description = description;
    this.itemCondition = itemCondition;
    this.zipcode = zipcode;
  }
  public Items(int itemId, Users user, String itemName, float price, String picture,
      String description, ItemCondition itemCondition, int zipcode) {
    this.users = user;
    this.itemId = itemId;
    this.itemName = itemName;
    this.price = price;
    this.picture = picture;
    this.description = description;
    this.itemCondition = itemCondition;
    this.zipcode = zipcode;
  }

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public int getItemId() {
    return itemId;
  }

  public void setItemId(int itemId) {
    this.itemId = itemId;
  }

  public Users getUsers() {
    return users;
  }

  public void setUsers(Users users) {
    this.users = users;
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ItemCondition getItemCondition() {
    return itemCondition;
  }

  public void setItemCondition(ItemCondition itemCondition) {
    this.itemCondition = itemCondition;
  }

  public int getZipcode() {
    return zipcode;
  }

  public void setZipcode(int zipcode) {
    this.zipcode = zipcode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Items)) {
      return false;
    }
    Items items = (Items) o;
    return getItemId() == items.getItemId() &&
        Float.compare(items.getPrice(), getPrice()) == 0 &&
        getZipcode() == items.getZipcode() &&
        Objects.equals(getItemName(), items.getItemName()) &&
        Objects.equals(getPicture(), items.getPicture()) &&
        Objects.equals(getDescription(), items.getDescription()) &&
        getItemCondition() == items.getItemCondition();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getItemId(), getItemName(), getPrice(), getPicture(), getDescription(),
        getItemCondition(), getZipcode());
  }

  @Override
  public String toString() {
    return "Items{" +
            "itemId=" + itemId +
            ", users=" + users +
            ", itemName='" + itemName + '\'' +
            ", price=" + price +
            ", picture='" + picture + '\'' +
            ", description='" + description + '\'' +
            ", itemCondition=" + itemCondition +
            ", zipcode=" + zipcode +
            '}';
  }
}
