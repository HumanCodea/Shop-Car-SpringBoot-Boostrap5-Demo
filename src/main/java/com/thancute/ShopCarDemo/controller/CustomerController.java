package com.thancute.ShopCarDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thancute.ShopCarDemo.model.Customer;
import com.thancute.ShopCarDemo.service.CustomerService;

@Controller
@RequestMapping(path = "")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    
    @GetMapping("/register")
    public String RegisterUser(){
        return "registerUser";
    }

    @GetMapping("/login")
    public String LoginUser(){
        return "loginUser";
    }

    @PostMapping("/saveUser")
    public String SaveUser(@ModelAttribute Customer customer){
        customerService.SaveUser(customer);
        return "redirect:/login";
    }
}
