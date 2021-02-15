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

}
