package com.laioffer.authdeal.entity;

import java.sql.Timestamp;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "messages")
public class Messages {

  private static final long serialVersionUID = -6571020028726257848L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int messageId;

  @ManyToOne
  private Users from;

  @ManyToOne
  private Users to;

  private String text;
  private boolean isRead;
  private Timestamp times;

  public Messages() {
  }

}
