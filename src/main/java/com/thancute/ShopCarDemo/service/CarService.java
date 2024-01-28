package com.thancute.ShopCarDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thancute.ShopCarDemo.model.Car;
import com.thancute.ShopCarDemo.repositories.CarRepository;

@Service
public class CarService {
    
    @Autowired
    public CarRepository carRepository;

    public List<Car> getAllCar(){
        return carRepository.findAll();
    }

    public void deleteCar(int id){
        carRepository.deleteById(id);
    }
    
    public void saveCar(Car car){
        carRepository.save(car);
    }

    public Car findCarById(int id){
        return carRepository.findById(id).get();
    }

    public List<Car> findCarByName(String nameCar){
        return carRepository.findCarByName(nameCar);
    }

}
