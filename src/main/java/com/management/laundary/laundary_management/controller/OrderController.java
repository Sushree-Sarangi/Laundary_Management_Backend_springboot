package com.management.laundary.laundary_management.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.laundary.laundary_management.bean.orderRequest;
import com.management.laundary.laundary_management.entity.Orders;
import com.management.laundary.laundary_management.service.OrderService;

@RestController
@RequestMapping("/orders")
@CrossOrigin("*")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/saveOrder")
    private Orders saveOrder(@RequestBody orderRequest request){

        System.out.println(request+" this is request");
        Orders order=Orders.builder().
                            bottomWearQuantity(request.getBottomWearQuantity()).
                            topWearQuantity(request.getTopWearQuantity()).
                            woolenClothQuantity(request.getWoolenClothQuantity()).
                            othersQuantity(request.getOthersQuantity()).
                            contactPerson(request.getContactPerson()).
                            description(request.getDescription()).
                            pickUpDate( LocalDate.parse(request.getPickUpDate())).
                            build();

        String user=request.getOrderedByEmail();
        return orderService.saveOrder(order,user);
    }
    @PostMapping(value="/getOrders")
    private List<Orders> getOrdersOfAUser(@RequestBody Map<String,String> map ,@RequestParam(value="orderStatus",required = false) String status ){
        String email=map.get("email");
        System.out.println(status+" order status");
        int orderStatus;
        if(status==null)
            return orderService.getAllOrderOfAUser(email);
        try{
            orderStatus=Integer.valueOf(status);
            return orderService.getAllOrderOfUserHavingOrderStatus(email,orderStatus);
        }        catch(NumberFormatException e){
            return orderService.getAllOrderOfAUser(email);
        }
    }
    @PutMapping(value = "/changeOrderStatus")
    private Orders updateOrders(@RequestBody Orders order){
        return orderService.changeOrderStatus(order);
    }

}
