package com.thancute.ShopCarDemo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.thancute.ShopCarDemo.model.MyCar;

@Repository
public interface MyCarRepository extends JpaRepository<MyCar, Integer>{
    
    @Query("Select c From MyCar c Where c.nameCar Like %?1%")
    public List<MyCar> findMyCarByName(String nameCar);
}
