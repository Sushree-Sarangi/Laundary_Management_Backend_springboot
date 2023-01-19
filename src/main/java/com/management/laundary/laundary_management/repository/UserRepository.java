package com.management.laundary.laundary_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.management.laundary.laundary_management.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query(value = "select user from User user where email=:email and password=:password")
    User findUserByEmailAndPassword(@Param("email") String email, @Param("password") String password);
    @Query(value = "select user from User user where email=:email")
    User findUserByEmail(@Param("email") String email);
    
}
