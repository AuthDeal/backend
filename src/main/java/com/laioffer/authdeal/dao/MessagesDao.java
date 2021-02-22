package com.laioffer.authdeal.dao;

import com.laioffer.authdeal.entity.Items;
import com.laioffer.authdeal.entity.Messages;
import com.laioffer.authdeal.repository.MessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Repository
public class MessagesDao {
    @Autowired MessagesRepository messagesRepository;
    public List<Messages> FindAllMassageByUser(String userId){
        List<Messages> ret = new ArrayList<>();
        for(Messages messages : messagesRepository.findAllMessagesOfUser(userId)){
            ret.add(messages);
        }
        Collections.sort(ret, new Comparator<Messages>() {
            @Override
            public int compare(Messages o1, Messages o2) {
                return o2.getTimes().compareTo(o1.getTimes());
            }
        });
        return ret;
    }
    public Messages CreateMessage(Messages message){
        return messagesRepository.save(message);
    }
}
