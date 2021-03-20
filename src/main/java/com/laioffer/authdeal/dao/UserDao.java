package com.laioffer.authdeal.dao;

import com.laioffer.authdeal.entity.Result;
import com.laioffer.authdeal.entity.Users;
import com.laioffer.authdeal.repository.UsersRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
  @Autowired
  UsersRepository usersRepository;

  public void createUsers(Users user) {
    usersRepository.save(user);
  }

  public Users findUserById(String userName) {
    return usersRepository.findById(userName).get();
  }

  public List<Users> findAllUsers() {
    List<Users> result = new ArrayList<>();
    for (Users user : usersRepository.findAll()) {
      result.add(user);
    }
    return result;
  }
}
