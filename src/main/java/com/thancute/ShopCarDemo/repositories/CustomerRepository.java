package com.thancute.ShopCarDemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thancute.ShopCarDemo.model.Customer;

import java.util.List;;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    
    public List<Customer> findByUsername(String username);
}
