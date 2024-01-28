package com.thancute.ShopCarDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thancute.ShopCarDemo.model.MyCar;
import com.thancute.ShopCarDemo.repositories.MyCarRepository;

@Service
public class MyCarService {
    
    @Autowired
    private MyCarRepository myCarRepository;

    public List<MyCar> getAllMyCar(){
        return myCarRepository.findAll();
    }

    public void deleteMyCar(int id){
        myCarRepository.deleteById(id);
    }

    public void saveMyCar(MyCar myCar){
        myCarRepository.save(myCar);
    }

    public List<MyCar> findMyCarByName(String nameCar){
        return myCarRepository.findMyCarByName(nameCar);
    }
}
