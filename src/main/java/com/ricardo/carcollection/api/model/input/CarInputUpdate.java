package com.ricardo.carcollection.api.model.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarInputUpdate {

    @NotNull
    private int year;
    @NotBlank
    private String model;
    @NotBlank
    private String color;

}
