package com.laioffer.authdeal.repository;

import com.laioffer.authdeal.entity.Items;
import com.laioffer.authdeal.entity.Messages;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessagesRepository extends CrudRepository<Messages, Integer> {
    @Query(value = "SELECT messages FROM Messages messages Where messages.from.userName=:user Or messages.to.userName=:user")
    List<Messages> findAllMessagesOfUser(@Param("user") String userId);
}
