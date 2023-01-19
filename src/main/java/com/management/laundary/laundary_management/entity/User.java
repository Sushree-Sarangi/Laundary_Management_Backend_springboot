package com.management.laundary.laundary_management.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    @NotBlank(message = "Enter a Valid User Name")
    private String fullName;

    @Column(unique = true)
    @Email(message = "Not a valid Email")
    private String email;

    @Column
    private String mobileNumber;

    @Size(min = 8,message = "Password Must be at least 8 character long")
    @Pattern(regexp = "^(?=.*[0-9])"
    + "(?=.*[a-z])(?=.*[A-Z])"
    + "(?=.*[@#$%^&+=])"
    + "(?=\\S+$).{8,20}$",
    message = "password should contain one small letter , one capital letter,  one number , one special character ")
    private String password;
    
    @JsonIgnore
    @CreationTimestamp
    private LocalDateTime createdOn;
    @JsonIgnore
    @UpdateTimestamp
    private LocalDateTime updatedOn;
}

