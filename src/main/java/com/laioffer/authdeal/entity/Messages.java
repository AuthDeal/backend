package com.laioffer.authdeal.entity;

import org.hibernate.type.NTextType;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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

  public Messages(int messageId, Users from, Users to, String text, boolean isRead, Timestamp times) {
    this.messageId = messageId;
    this.from = from;
    this.to = to;
    this.text = text;
    this.isRead = isRead;
    this.times = times;
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

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public boolean isRead() {
    return isRead;
  }

  public void setRead(boolean read) {
    isRead = read;
  }

  public Timestamp getTimes() {
    return times;
  }

  public void setTimes(Timestamp times) {
    this.times = times;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Messages messages = (Messages) o;
    return messageId == messages.messageId &&
            isRead == messages.isRead &&
            from.equals(messages.from) &&
            to.equals(messages.to) &&
            text.equals(messages.text) &&
            times.equals(messages.times);
  }

  @Override
  public int hashCode() {
    return Objects.hash(messageId, from, to, text, isRead, times);
  }

  @Override
  public String toString() {
    return "Messages{" +
            "messageId=" + messageId +
            ", from=" + from +
            ", to=" + to +
            ", text='" + text + '\'' +
            ", isRead=" + isRead +
            ", times=" + times +
            '}';
  }
}
