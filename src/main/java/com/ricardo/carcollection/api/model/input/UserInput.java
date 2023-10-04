package com.ricardo.carcollection.api.model.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class UserInput {

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String email;
    @NotNull
    private Date birthday;
    @NotBlank
    private String login;
    @NotBlank
    private String password;
    @NotBlank
    private String phone;

    private List<CarInput> cars;

}
