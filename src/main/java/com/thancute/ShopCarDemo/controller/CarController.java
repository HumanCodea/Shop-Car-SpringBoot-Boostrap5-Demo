package com.thancute.ShopCarDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import com.thancute.ShopCarDemo.model.Car;
import com.thancute.ShopCarDemo.model.MyCar;
import com.thancute.ShopCarDemo.service.CarService;
import com.thancute.ShopCarDemo.service.MyCarService;


@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private MyCarService myCarService;
    
    @GetMapping("/home")
    public String HomeUser(){
        return "homeUser";
    }

    @GetMapping("/available_car")
    public String getAllCar(@Param("nameCar") String nameCar, Model model){
        List<Car> list = carService.getAllCar();
        if(nameCar != null){
            list = carService.findCarByName(nameCar);
            model.addAttribute("nameCar", nameCar);
        }
        model.addAttribute("car", list);
        return "listCar";
    }

    @RequestMapping("/deleteList/{id}")
    public String deleteCar(@PathVariable("id") int id){
        carService.deleteCar(id);
        return "redirect:/available_car";
    }

    @GetMapping("/car_register")
    public String carRegister(){
        return "registerCar";
    }

    @PostMapping("/save")
    public String SaveCar(@ModelAttribute Car car){
        carService.saveCar(car);
        return "redirect:/available_car";
    }

    @RequestMapping("/editList/{id}")
    public String EditCar(@PathVariable("id") int id, Model model){
        Car carOld = carService.findCarById(id);
        model.addAttribute("car", carOld);
        return "editCar";
    }

    @RequestMapping("/mylist/{id}")
    public String addToMyCar(@PathVariable("id") int id){
        Car carOld = carService.findCarById(id);
        MyCar myCar = new MyCar(carOld.getId(), carOld.getNameCar(), carOld.getManufacturer(), carOld.getColorCar(), carOld.getCounts(), carOld.getYears(), carOld.getPrices());
        myCarService.saveMyCar(myCar);
        return "redirect:/my_car";
    }

    @GetMapping("/homeAdmin")
    public String HomeAdmin(){
        return "homeAdmin";
    }

}
