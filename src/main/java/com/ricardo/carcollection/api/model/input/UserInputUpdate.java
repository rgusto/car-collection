package com.ricardo.carcollection.api.model.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserInputUpdate {

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotNull
    private Date birthday;
    @NotBlank
    private String phone;

}
