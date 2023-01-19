package com.management.laundary.laundary_management.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;
    private int topWearQuantity;
    private int bottomWearQuantity;
    private int woolenClothQuantity;
    private int othersQuantity;
    @NotBlank(message = "can not be empty")
    private String contactPerson;
    private String description; 
    private LocalDate pickUpDate;
    @JsonIgnore
    @CreationTimestamp
    private LocalDateTime createdOn;
    @UpdateTimestamp
    @JsonIgnore
    private LocalDateTime updatedOn;
    @OneToOne
    @JsonIgnore
    @NotNull
    private User orderedBy;
    @Column(columnDefinition = "int default 0")
    private int orderStatus;
}
