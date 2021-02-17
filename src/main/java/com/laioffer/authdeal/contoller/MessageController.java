package com.laioffer.authdeal.contoller;

import com.laioffer.authdeal.dao.MessageDao;
import com.laioffer.authdeal.entity.Messages;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

  @Autowired
  MessageDao messageDao;

  @RequestMapping(value="/messages", method = RequestMethod.POST)
  public Messages addDiscussionComment(Messages newMsg) {
    return messageDao.createMsg(newMsg);
  }

  @RequestMapping(value = "/messages/all", method = RequestMethod.GET)
  public List<Messages> fetchAllMsgs() {
    return messageDao.findAllMsgs();
  }

  @RequestMapping(value = "/messages/{userName}", method = RequestMethod.GET)
  public List<Messages> getMsgByUser(@PathVariable(value = "userName") String userName) {
    return messageDao.findMsgByUser(userName);
  }

  @RequestMapping(value = "/messages/{receiver}/{sender}", method = RequestMethod.GET)
  public List<Messages> getMsgByFromReceiverAndSender(@PathVariable String sender,
      @PathVariable String receiver) {
    return messageDao.findMsgByReceiverAndSender(sender, receiver);
  }
}
