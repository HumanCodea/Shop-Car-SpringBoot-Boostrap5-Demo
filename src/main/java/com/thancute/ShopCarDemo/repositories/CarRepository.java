package com.thancute.ShopCarDemo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.thancute.ShopCarDemo.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer>{
    
    @Query("Select c From Car c Where c.nameCar LIKE %?1%")
    public List<Car> findCarByName(String nameCar);

}
