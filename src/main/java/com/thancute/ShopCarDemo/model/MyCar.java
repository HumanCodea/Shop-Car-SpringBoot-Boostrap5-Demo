package com.thancute.ShopCarDemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class MyCar {

    @Id
    private int id;
    @Column(name = "name_car")
    private String nameCar;
    private String manufacturer;
    private String colorCar;
    private int counts;
    private String years;
    private String prices;
    
    public MyCar() {
    }

    public MyCar(int id, String nameCar, String manufacturer, String colorCar, int counts, String years,
            String prices) {
        this.id = id;
        this.nameCar = nameCar;
        this.manufacturer = manufacturer;
        this.colorCar = colorCar;
        this.counts = counts;
        this.years = years;
        this.prices = prices;
    }

    

}
