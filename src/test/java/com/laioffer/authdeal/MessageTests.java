package com.laioffer.authdeal;

import com.laioffer.authdeal.dao.MessagesDao;
import com.laioffer.authdeal.entity.Messages;
import com.laioffer.authdeal.entity.Users;
import com.laioffer.authdeal.repository.ItemsRepository;
import com.laioffer.authdeal.repository.MessagesRepository;
import com.laioffer.authdeal.repository.UsersRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MessageTests {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    ItemsRepository itemsRepository;
    @Autowired
    MessagesDao messagesDao;
    @Test
    void contextLoads() {
        Users seller = new Users();
        seller.setUserName("123@gmail.com");
        seller.setPassword("123");
        seller.setPhoneNum("123-456-7890");
        seller = usersRepository.save(seller);

        Users buyer = new Users();
        buyer.setUserName("456@gmail.com");
        buyer.setPassword("456");
        buyer.setPhoneNum("123-456-7890");
        buyer = usersRepository.save(buyer);

        Messages message1 = new Messages();
        message1.setFrom(buyer);
        message1.setTo(seller);
        message1.setText("aaaaaaaaaaaa");
        message1 = messagesDao.CreateMessage(message1);
        Messages message2 = new Messages();

        message2.setFrom(seller);
        message2.setTo(buyer);
        message2.setText("bbbbbbbbbbb");
        message2 = messagesDao.CreateMessage(message2);

        for(Messages i :messagesDao.FindAllMassageByUser(seller.getUserName())){
            System.out.println(i.toString());
        }

    }
}
