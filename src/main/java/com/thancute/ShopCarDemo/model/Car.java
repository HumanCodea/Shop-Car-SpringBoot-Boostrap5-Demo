package com.thancute.ShopCarDemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Car {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name_car")
    private String nameCar;
    private String manufacturer;
    private String colorCar;
    private int counts;
    private String years;
    private String prices;
    
    public Car() {
    }

    public Car(String nameCar, String manufacturer, String colorCar, int counts, String years, String prices) {
        this.nameCar = nameCar;
        this.manufacturer = manufacturer;
        this.colorCar = colorCar;
        this.counts = counts;
        this.years = years;
        this.prices = prices;
    }

    

}
