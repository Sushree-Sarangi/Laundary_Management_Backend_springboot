package com.management.laundary.laundary_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.laundary.laundary_management.entity.Orders;
import com.management.laundary.laundary_management.entity.User;
import com.management.laundary.laundary_management.repository.OrderRepository;
import com.management.laundary.laundary_management.repository.UserRepository;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepo;
    @Autowired
    UserRepository userRepo;
    
    public  Orders saveOrder(Orders order,String email){
        User user=userRepo.findUserByEmail(email);
        if(user==null)
            return null;
        if(order.getBottomWearQuantity()+order.getTopWearQuantity()+order.getWoolenClothQuantity()+order.getOthersQuantity()==0)
            return null;
        order.setOrderStatus(0);
        order.setOrderedBy(user);
        return orderRepo.save(order);
    }
    public  List<Orders> getAllOrderOfAUser(String email){
        return orderRepo.getAllOrderOfAUser(email);
    } 
    public Orders changeOrderStatus(Orders order){
        Orders oldOrder=orderRepo.findById(order.getId()).orElse(null);
        if(oldOrder==null)
            return null;
        oldOrder.setOrderStatus(order.getOrderStatus());
        return orderRepo.save(oldOrder);

    }
    public List<Orders> getAllOrderOfUserHavingOrderStatus(String email, Integer orderStatus) {
        return orderRepo.getAllOrderOfUserHavingOrderStatus(email,orderStatus);
    }
}
