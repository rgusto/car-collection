package com.ricardo.carcollection.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarModel {

    private Long id;
    private int year;
    private String licensePlate;
    private String model;
    private String color;

}
