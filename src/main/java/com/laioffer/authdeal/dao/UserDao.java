package com.laioffer.authdeal.dao;

import com.laioffer.authdeal.entity.Users;
import com.laioffer.authdeal.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {
    @Autowired
    UsersRepository usersRepository;

    public void createUsers(Users user) {
        usersRepository.save(user);
    }
    public List<Users> findAllUsers(){
        List<Users> ret = new ArrayList<>();
        for(Users user:usersRepository.findAll()){
            ret.add(user);
        }
        return ret;
    }
    public  Users findUsersByID(int id){
        return usersRepository.findById(id).get();
    }

}
