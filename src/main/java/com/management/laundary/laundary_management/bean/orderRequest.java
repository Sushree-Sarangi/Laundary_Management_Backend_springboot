package com.management.laundary.laundary_management.bean;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class orderRequest {
    private long id;
    private int topWearQuantity;
    private int bottomWearQuantity;
    private int woolenClothQuantity;
    private int othersQuantity;
    private String contactPerson;
    private String description; 
    private String pickUpDate;
    private int orderStatus;
    private String orderedByEmail;
}
