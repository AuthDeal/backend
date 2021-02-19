package com.laioffer.authdeal.repository;

import com.laioffer.authdeal.entity.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Orders, Integer> {
}
