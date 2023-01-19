package com.management.laundary.laundary_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.management.laundary.laundary_management.entity.Orders;

@Repository
public interface OrderRepository  extends JpaRepository<Orders,Long>{
    @Query(value = "select order from Orders order where order.orderedBy.email=:email")
    List<Orders> getAllOrderOfAUser(@Param("email") String email);
    @Query(value = "select order from Orders order where order.orderedBy.email=:email and order.orderStatus=:orderStatus")
    List<Orders> getAllOrderOfUserHavingOrderStatus(@Param("email") String email, @Param("orderStatus") Integer orderStatus);
    
}
