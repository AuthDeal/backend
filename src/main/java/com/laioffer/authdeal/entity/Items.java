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
import org.springframework.data.relational.core.sql.In;

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

//  @Enumerated(EnumType.STRING)
//  @Column(length = 8)
//  private ItemCondition condition;

  private int zipcode;

}
