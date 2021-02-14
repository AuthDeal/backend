package com.laioffer.authdeal.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users implements Serializable {

  private static final long serialVersionUID = 2681531852204068105L;

  @Id
  private String userName;
  private String password;
  private boolean enabled;
  private float rate;
  private String picture;

  public Users() {
  }

  public Users(String userName, String password, boolean enabled, float rate, String picture) {
    this.userName = userName;
    this.password = password;
    this.enabled = enabled;
    this.rate = rate;
    this.picture = picture;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String user) {
    this.userName = user;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public float getRate() {
    return rate;
  }

  public void setRate(float rate) {
    this.rate = rate;
  }

  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Users)) {
      return false;
    }
    Users users1 = (Users) o;
    return isEnabled() == users1.isEnabled() &&
        Float.compare(users1.getRate(), getRate()) == 0 &&
        Objects.equals(getUserName(), users1.getUserName()) &&
        Objects.equals(getPassword(), users1.getPassword()) &&
        Objects.equals(getPicture(), users1.getPicture());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getUserName(), getPassword(), isEnabled(), getRate(), getPicture());
  }

  @Override
  public String toString() {
    return "Users{" +
        "userName='" + userName + '\'' +
        ", password='" + password + '\'' +
        ", enabled=" + enabled +
        ", rate=" + rate +
        ", picture='" + picture + '\'' +
        '}';
  }
}
