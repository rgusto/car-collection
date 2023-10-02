package com.ricardo.carcollection.api.model.input;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CarInputUpdate {

    @NotNull
    private int year;
    @NotBlank
    private String licensePlate;
    @NotBlank
    private String model;
    @NotBlank
    private String color;

}
