package com.ricardo.carcollection.api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CarModel {

    private UUID id;
    private int year;
    private String licensePlate;
    private String model;
    private String color;

}
