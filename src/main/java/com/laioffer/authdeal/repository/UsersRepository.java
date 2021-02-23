package com.laioffer.authdeal.repository;

import com.laioffer.authdeal.entity.Messages;
import com.laioffer.authdeal.entity.Users;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UsersRepository {

  @Select(value = "select u.username,u.password from user u where u.username=#{username}")
  @Results
      ({@Result(property = "username",column = "username"),
          @Result(property = "password",column = "password")})
  Users findUserByName(@Param("username") String username);

  @Insert("insert into user values(#{username},#{password},#{phoneNum})")
  @Options(useGeneratedKeys = true, keyProperty = "username",keyColumn = "username")
  void register(Users user);

  @Select("select u.username from users u where u.username = #{username} and password = #{password}")
  String login(Users user);

  @Query(value = "SELECT userName FROM Users")
  List<Users> findAllUsers();

  @Query(value = "SELECT messages FROM Messages messages Where messages.from.userName=:user Or messages.to.userName=:user")
  List<Messages> findAllMessagesOfUser(@Param("user") String userId);
}
