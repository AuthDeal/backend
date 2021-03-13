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
    usersRepository.register(user);
  }

  public Result register(Users user) {
    Result result = new Result();
    result.setSuccess(false);
    result.setDetail(null);
    try {
      Users existUser = usersRepository.findUserByName(user.getUserName());
      if(existUser != null){
        // Username already exists
        result.setMsg("Username already exists");
      }else{
        createUsers(user);
        //System.out.println(user.getId());
        result.setMsg("Success");
        result.setSuccess(true);
        result.setDetail(user);
      }
    } catch (Exception e) {
      result.setMsg(e.getMessage());
      e.printStackTrace();
    }
    return result;
  }

  public Result login(Users user) {
    Result result = new Result();
    result.setSuccess(false);
    result.setDetail(null);
    try {
      String userName= usersRepository.login(user);
      if(userName == null){
        result.setMsg("Invalid user name or password");
      }else{
        result.setMsg("Success");
        result.setSuccess(true);
        user.setUserName(userName);
        result.setDetail(user);
      }
    } catch (Exception e) {
      result.setMsg(e.getMessage());
      e.printStackTrace();
    }
    return result;
  }

  public void updateUsers(Users user) {
    usersRepository.register(user);
  }

  public Users findUserById(String userName) {
    return usersRepository.findUserByName(userName);
  }

  public List<Users> findAllUsers() {
    return usersRepository.findAllUsers();
  }


}
