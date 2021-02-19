package com.laioffer.authdeal;

import com.laioffer.authdeal.dao.UserDao;
import com.laioffer.authdeal.entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UsersDaoTest {
    @Autowired
    UserDao usersDao;
    @Test
    void contextLoads(){
        Users example = new Users();
        example.setUserName("1234");
        example.setPassword("aaaaaaa");
        usersDao.createUsers(example);
        for(Users i: usersDao.findAllUsers()){
            System.out.println(i.toString());
        }
    }
}

