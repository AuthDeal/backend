package com.laioffer.authdeal.repository;

import com.laioffer.authdeal.entity.Items;
import com.laioffer.authdeal.entity.Users;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemsRepository extends CrudRepository<Items, Integer> {
    @Query(value = "SELECT items FROM Items items Where items.users.userName=:seller")
    List<Items> findAllItemsOfSeller(@Param("seller") String seller);

}
