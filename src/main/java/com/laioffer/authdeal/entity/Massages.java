package com.laioffer.authdeal.entity;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "messages")
public class Massages {

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

  public Massages() {
  }
/*
  public Massages(int messageId, Users from, Users to, String content, boolean read,
      Timestamp timestamp) {
    this.messageId = messageId;
    this.from = from;
    this.to = to;
    this.content = content;
    this.read = read;
    this.timestamp = timestamp;
  }

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public int getMessageId() {
    return messageId;
  }

  public void setMessageId(int messageId) {
    this.messageId = messageId;
  }

  public Users getFrom() {
    return from;
  }

  public void setFrom(Users from) {
    this.from = from;
  }

  public Users getTo() {
    return to;
  }

  public void setTo(Users to) {
    this.to = to;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public boolean isRead() {
    return read;
  }

  public void setRead(boolean read) {
    this.read = read;
  }

  public Timestamp getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Timestamp timestamp) {
    this.timestamp = timestamp;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Massages)) {
      return false;
    }
    Massages massages = (Massages) o;
    return getMessageId() == massages.getMessageId() &&
        isRead() == massages.isRead() &&
        Objects.equals(getContent(), massages.getContent()) &&
        Objects.equals(getTimestamp(), massages.getTimestamp());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getMessageId(), getContent(), isRead(), getTimestamp());
  }

 */
}
