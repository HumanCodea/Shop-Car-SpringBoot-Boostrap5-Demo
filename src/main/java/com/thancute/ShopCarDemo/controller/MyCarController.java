package com.thancute.ShopCarDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thancute.ShopCarDemo.model.MyCar;
import com.thancute.ShopCarDemo.service.MyCarService;


@Controller
public class MyCarController {
    
    @Autowired
    private MyCarService myCarService;

    @GetMapping("/my_car")
    public String getAllMyCar(@Param("nameCar") String nameCar, Model model){
        List<MyCar> list = myCarService.getAllMyCar();
        if(nameCar != null){
            list = myCarService.findMyCarByName(nameCar);
            model.addAttribute("nameCar", nameCar);
        }
        model.addAttribute("car", list);
        return "myCar";
    }

    @RequestMapping("/deleteMyList/{id}")
    public String deleteMyCar(@PathVariable("id") int id){
        myCarService.deleteMyCar(id);
        return "redirect:/my_car";
    }


}
